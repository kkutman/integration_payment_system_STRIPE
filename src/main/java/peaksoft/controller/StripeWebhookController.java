package peaksoft.controller;

import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.*;
import com.stripe.net.Webhook;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class StripeWebhookController {
    @Value("${stripe.webhook.secret}")
    private String endpointSecret;
    private final Logger logger = LoggerFactory.getLogger(StripeWebhookController.class);

    @PostMapping("/stripe/events")
    public String handlerStripeEvent(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
        if (sigHeader == null) {
            return "";
        }
        Event event;

        try {
            event = Webhook.constructEvent(
                    payload, sigHeader, endpointSecret
            );
        } catch (SignatureVerificationException e) {
            logger.info("⚠️  Webhook error while validating signature.");
            return "";
        }

        EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
        StripeObject stripeObject = null;
        if (dataObjectDeserializer.getObject().isPresent()) {
            stripeObject = dataObjectDeserializer.getObject().get();
        }

        if (event.getType().equals("payment_intent.succeeded")) {
            PaymentIntent paymentIntent = (PaymentIntent) stripeObject;
            assert paymentIntent != null;
            logger.info("Payment for id =" + paymentIntent.getId() + " , " + paymentIntent.getAmount() + " succeeded.");
        } else {
            logger.warn("Unhandled event type: " + event.getType());
        }
        return "";
    }
}

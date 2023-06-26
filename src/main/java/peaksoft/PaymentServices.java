package peaksoft;

import org.springframework.stereotype.Service;
import peaksoft.dto.PaymentResponse;
@Service
public class PaymentServices implements PaymentServicesSer{
    @Override
    public PaymentResponse paymentMethod(String token){
        String[]payment = token.split("&");
        //payment_intent
        String[]split1 = payment[0].split("=");
        String payment_intent = split1[1];

        //payment_intent_client_secret
        String[]split2 = payment[1].split("=");
        String payment_intent_client_secret = split2[1];

        //redirect_status
        String[]split3 = payment[2].split("=");
        String redirect_status = split3[1];
        return new PaymentResponse(payment_intent,payment_intent_client_secret,redirect_status);
    }
}

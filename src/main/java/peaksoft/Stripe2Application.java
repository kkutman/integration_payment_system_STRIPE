package peaksoft;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Stripe2Application {
    @Value("${stripe.api.key}")
    private String stripeApiKey;
    @PostConstruct
    public void setup(){
        Stripe.apiKey = stripeApiKey;
    }

    public static void main(String[] args) {
        SpringApplication.run(Stripe2Application.class, args);
    }

}

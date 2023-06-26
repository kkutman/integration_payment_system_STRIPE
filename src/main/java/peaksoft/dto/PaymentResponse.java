package peaksoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponse {
    private String payment_intent;
    private String payment_intent_client_secret;
    private String redirect_status;
}

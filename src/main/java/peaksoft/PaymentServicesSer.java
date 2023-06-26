package peaksoft;

import peaksoft.dto.PaymentResponse;

public interface PaymentServicesSer {
    public PaymentResponse paymentMethod(String token);
}

package com.sktelecom.nova.billing.payment.api;


import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentDto createPayment(PaymentCreationRequest paymentCreationRequest);
    PaymentDto getPaymentById(UUID paymentId);
    List<PaymentDto> findAllPayments();
}

package com.sktelecom.nova.billing.payment.internal;

import com.sktelecom.nova.billing.payment.api.PaymentDto;
import com.sktelecom.nova.billing.payment.api.PaymentCreationRequest;
import com.sktelecom.nova.billing.payment.api.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional
    public PaymentDto createPayment(PaymentCreationRequest paymentCreationRequest) {
        Payment createdPayment = paymentRepository.save(
                Payment.createPayment(paymentCreationRequest.invoiceId(), paymentCreationRequest.amount())
        );

        eventPublisher.publishEvent(createdPayment.createPaymentCreatedEvent());

        return PaymentMapper.toPaymentDto(createdPayment);
    }

    @Override
    public PaymentDto getPaymentById(UUID paymentId) {
        return paymentRepository.findById(paymentId).map(PaymentMapper::toPaymentDto)
                .orElseThrow(()->new RuntimeException("Payment not found"));
    }

    @Override
    public List<PaymentDto> findAllPayments() {
        return paymentRepository.findAll().stream().map(PaymentMapper::toPaymentDto).toList();
    }
}

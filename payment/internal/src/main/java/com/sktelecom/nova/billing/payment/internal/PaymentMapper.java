package com.sktelecom.nova.billing.payment.internal;

import com.sktelecom.nova.billing.payment.api.PaymentDto;

class PaymentMapper {
    static PaymentDto toPaymentDto(Payment payment) {
        return new PaymentDto(payment.getId(), payment.getInvoiceId(), payment.getAmount());
    }
}

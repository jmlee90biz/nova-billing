package com.sktelecom.nova.billing.payment.api;

import com.sktelecom.nova.billing.invoice.event.InvoiceCreatedEvent;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentCreationRequest(UUID invoiceId, BigDecimal amount) {
    public static PaymentCreationRequest createInvoiceCreationOrUpdateRequest(InvoiceCreatedEvent invoiceCreatedEvent) {
        return new PaymentCreationRequest(invoiceCreatedEvent.id(), invoiceCreatedEvent.amount());
    }
}
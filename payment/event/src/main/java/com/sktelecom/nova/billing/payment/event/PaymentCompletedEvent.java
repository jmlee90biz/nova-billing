package com.sktelecom.nova.billing.payment.event;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentCompletedEvent(UUID id, UUID invoiceId, BigDecimal amount) {
}

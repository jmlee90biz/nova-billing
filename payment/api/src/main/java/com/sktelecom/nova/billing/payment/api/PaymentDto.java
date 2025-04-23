package com.sktelecom.nova.billing.payment.api;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDto(UUID id, UUID invoiceId, BigDecimal amount) {
}

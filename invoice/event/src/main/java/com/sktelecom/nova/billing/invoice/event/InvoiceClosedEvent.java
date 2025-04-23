package com.sktelecom.nova.billing.invoice.event;

import java.math.BigDecimal;
import java.util.UUID;

public record InvoiceClosedEvent(UUID id, UUID customerId, BigDecimal amount) {
}

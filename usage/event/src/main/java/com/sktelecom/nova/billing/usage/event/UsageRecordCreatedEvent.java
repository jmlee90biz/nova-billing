package com.sktelecom.nova.billing.payment.event;

import java.util.UUID;

public record UsageRecordCreatedEvent(UUID id, UUID customerId, UUID productId, int usage) {
}

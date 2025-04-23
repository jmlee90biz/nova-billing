package com.sktelecom.nova.billing.usage.event;

import java.util.UUID;

public record UsageRecordCreatedEvent(UUID id, UUID customerId, UUID productId, int usage) {
}

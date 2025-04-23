package com.sktelecom.nova.billing.usage.api;

import java.util.UUID;

public record UsageRecordDto(UUID id, UUID customerId, UUID productId, int usage) {
}

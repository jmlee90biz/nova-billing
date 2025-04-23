package com.sktelecom.nova.billing.usage.api;

import java.util.UUID;

public record UsageRecordCreationRequest(UUID customerId, UUID productId, int usage) {
}
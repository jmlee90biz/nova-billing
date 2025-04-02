package com.sktelecom.nova.billing.payment.api;

import java.util.UUID;

public record UsageRecordCreationRequest(UUID customerId, UUID productId, int usage) {
}
package com.sktelecom.nova.billing.invoice.api;

import java.math.BigDecimal;
import java.util.UUID;

public record InvoiceDto(
            UUID id,
            UUID customerId, BigDecimal amount,

            String subscriptionStatus, String customerName, String customerEmail,

            UUID pricingPlanId,
            UUID productId,
            String productName,
            String productDescription,
            String pricingPlanName,
            BigDecimal price
) {
}

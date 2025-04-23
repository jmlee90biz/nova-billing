package com.sktelecom.nova.billing.invoice.internal;

import com.sktelecom.nova.billing.invoice.api.InvoiceDto;

class InvoiceMapper {
    static InvoiceDto toInvoiceDto(Invoice invoice) {
        return new InvoiceDto(invoice.getId(), invoice.getCustomerId(), invoice.getAmount(),
                invoice.getSubscriptionStatus(), invoice.getCustomerName(), invoice.getCustomerEmail(),
                invoice.getPricingPlanId(), invoice.getProductId(), invoice.getProductName(), invoice.getProductDescription(),
                invoice.getPricingPlanName(), invoice.getPrice());
    }
}

package com.sktelecom.nova.billing.invoice.api;

import com.sktelecom.nova.customer.subscription.event.SubscriptionActivatedEvent;

public record InvoiceCreationRequest(SubscriptionActivatedEvent subscriptionActivatedEvent) {
    public static InvoiceCreationRequest createInvoiceCreationOrUpdateRequest(SubscriptionActivatedEvent subscriptionActivatedEvent) {
        return new InvoiceCreationRequest(subscriptionActivatedEvent);
    }
}

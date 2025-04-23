package com.sktelecom.nova.billing.invoice.internal;

import com.sktelecom.nova.billing.invoice.api.InvoiceCreationRequest;
import com.sktelecom.nova.billing.invoice.api.InvoiceService;
import com.sktelecom.nova.billing.invoice.event.InvoiceClosedEvent;
import com.sktelecom.nova.billing.usage.event.UsageRecordCreatedEvent;

import com.sktelecom.nova.customer.subscription.event.SubscriptionActivatedEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InvoiceEventListener {
    private final InvoiceService invoiceService;
    private final ApplicationEventPublisher eventPublisher;

    //@Async("taskExecutor")
    //@ApplicationModuleListener
    @EventListener
    @Transactional
    public void onSubscriptionActivatedEvent(final SubscriptionActivatedEvent subscriptionActivatedEvent) {
        invoiceService.createInvoice(InvoiceCreationRequest.createInvoiceCreationOrUpdateRequest(subscriptionActivatedEvent));
    }

    @ApplicationModuleListener
    public void onUsageRecordCreationEvent(final UsageRecordCreatedEvent usageRecordCreatedEvent) {
        //invoiceService.createInvoice(InvoiceCreationRequest.createInvoiceCreationOrUpdateRequest(subscriptionActivatedEvent));
    }

    //@Async("taskExecutor")
    @ApplicationModuleListener
    public void onInvoiceClosedEvent(final InvoiceClosedEvent invoiceClosedEvent) {
//        eventPublisher.publish(
//                NotificationRequestedEvent.create(
//                        "",
//                        "Customer Registered",
//                        "Welcome!"
//                )
//        );
    }
}

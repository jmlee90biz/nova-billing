package com.sktelecom.nova.billing.payment.internal;

import com.sktelecom.nova.billing.invoice.event.InvoiceClosedEvent;

import com.sktelecom.nova.billing.invoice.event.InvoiceCreatedEvent;
import com.sktelecom.nova.billing.payment.api.PaymentCreationRequest;
import com.sktelecom.nova.billing.payment.api.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PaymentEventListener {
    private final PaymentService paymentService;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    @EventListener
    public void onInvoiceCreatedEvent(InvoiceCreatedEvent invoiceCreatedEvent) {
        paymentService.createPayment(PaymentCreationRequest.createInvoiceCreationOrUpdateRequest(invoiceCreatedEvent));
    }

    //@Async("taskExecutor")
    @ApplicationModuleListener
    public void onInvoiceClosedEvent(final InvoiceClosedEvent invoiceClosedEvent) {
//        SubscriptionCustomerProductPricingPlanDto subscriptionCustomerProductPricingPlanDto =
//                subscriptionService.findSubscriptionCustomerProductPricingPlanById(subscriptionActivatedEvent.id());
//
//        eventPublisher.publish(
//                NotificationRequestedEvent.create(
//                        subscriptionCustomerProductPricingPlanDto.customerEmail(),
//                        "Subscription Activated",
//                        subscriptionCustomerProductPricingPlanDto.productName() + " " +
//                                subscriptionCustomerProductPricingPlanDto.pricingPlanName()
//                )
//        );
//        eventPublisher.publish(
//                NotificationRequestedEvent.create(
//                        "",
//                        "Customer Registered",
//                        "Welcome!"
//                )
//        );
    }

}

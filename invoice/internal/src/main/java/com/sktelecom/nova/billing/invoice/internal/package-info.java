@ApplicationModule(
        displayName = "billing-invoice-internal",
        allowedDependencies = {
                "billing.invoice.api",
                "billing.invoice.event",
                "billing.usage.event",
                "customer.subscription.event"
        }
)
package com.sktelecom.nova.billing.invoice.internal;

import org.springframework.modulith.ApplicationModule;
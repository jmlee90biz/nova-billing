@ApplicationModule(
        displayName = "billing-payment-internal",
        allowedDependencies = {
                "billing.payment.api",
                "billing.payment.event",
                "billing.invoice.event"
        }
)
package com.sktelecom.nova.billing.payment.internal;

import org.springframework.modulith.ApplicationModule;
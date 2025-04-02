@ApplicationModule(
        displayName = "billing-usage-internal",
        allowedDependencies = {
                "billing.usage.api"
        }
)
package com.sktelecom.nova.billing.payment.internal;

import org.springframework.modulith.ApplicationModule;
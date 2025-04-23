@ApplicationModule(
        displayName = "billing-usage-internal",
        allowedDependencies = {
                "billing.usage.api",
                "billing.usage.event"
        }
)
package com.sktelecom.nova.billing.usage.internal;

import org.springframework.modulith.ApplicationModule;
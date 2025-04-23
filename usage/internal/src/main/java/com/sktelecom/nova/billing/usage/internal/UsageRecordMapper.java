package com.sktelecom.nova.billing.usage.internal;

import com.sktelecom.nova.billing.usage.api.UsageRecordDto;

class UsageRecordMapper {
    static UsageRecordDto toUsageRecordDto(UsageRecord usageRecord) {
        return new UsageRecordDto(usageRecord.getId(), usageRecord.getCustomerId(), usageRecord.getProductId(), usageRecord.getUsage());
    }
}

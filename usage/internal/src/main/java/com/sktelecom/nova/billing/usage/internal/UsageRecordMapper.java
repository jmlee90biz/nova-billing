package com.sktelecom.nova.billing.payment.internal;

import com.sktelecom.nova.billing.payment.api.UsageRecordDto;

class UsageRecordMapper {
    static UsageRecordDto toUsageRecordDto(UsageRecord usageRecord) {
        return new UsageRecordDto(usageRecord.getId(), usageRecord.getCustomerId(), usageRecord.getProductId(), usageRecord.getUsage());
    }
}

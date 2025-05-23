package com.sktelecom.nova.billing.usage.api;

import java.util.List;
import java.util.UUID;

public interface UsageService {
    UsageRecordDto createUsageRecord(UsageRecordCreationRequest usageRecordCreationRequest);
    UsageRecordDto getUsageRecordById(UUID usageRecordId);
    List<UsageRecordDto> findAllUsageRecords();
}

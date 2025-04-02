package com.sktelecom.nova.billing.payment.internal;

import com.sktelecom.nova.billing.payment.api.UsageRecordCreationRequest;
import com.sktelecom.nova.billing.payment.api.UsageRecordDto;
import com.sktelecom.nova.billing.payment.api.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/billing/usageRecords")
class UsageRecordController {
    private final UsageService usageService;

    @GetMapping("/{id}")
    public UsageRecordDto getUsageRecordById(@PathVariable(name="id") UUID partnerId) {
        return usageService.getUsageRecordById(partnerId);
    }

    @PostMapping
    public UsageRecordDto createU(UsageRecordCreationRequest usageRecordCreateionRequest) {
        return usageService.createUsageRecord(usageRecordCreateionRequest);
    }

    @GetMapping
    public List<UsageRecordDto> getAllPartners() {
        return usageService.findAllUsageRecords();
    }


}

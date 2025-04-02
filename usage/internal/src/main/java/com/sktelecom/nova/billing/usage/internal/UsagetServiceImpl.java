package com.sktelecom.nova.billing.payment.internal;

import com.sktelecom.nova.billing.payment.api.UsageRecordCreationRequest;
import com.sktelecom.nova.billing.payment.api.UsageRecordDto;
import com.sktelecom.nova.billing.payment.api.UsageService;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class UsagetServiceImpl implements UsageService {
    private final UsageRecordRepository usageRecordRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    @Override
    public UsageRecordDto createUsageRecord(UsageRecordCreationRequest usageRecordCreationRequest) {
        UsageRecord registeredPartner = usageRecordRepository.save(
                UsageRecord.createUsageRecord(usageRecordCreationRequest.customerId(), usageRecordCreationRequest.productId(), usageRecordCreationRequest.usage())
        );

        eventPublisher.publishEvent(registeredPartner.createUsageRecordCreatedEvent());

        return UsageRecordMapper.toUsageRecordDto(registeredPartner);
    }

    @Override
    public UsageRecordDto getUsageRecordById(UUID usageRecordId) {
        return usageRecordRepository.findById(usageRecordId).map(UsageRecordMapper::toUsageRecordDto)
                .orElseThrow(()->new RuntimeException("Partner not found"));
    }

    @Override
    public List<UsageRecordDto> findAllUsageRecords() {
        return usageRecordRepository.findAll().stream().map(UsageRecordMapper::toUsageRecordDto).toList();
    }
}

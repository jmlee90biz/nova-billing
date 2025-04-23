package com.sktelecom.nova.billing.invoice.internal;

import com.sktelecom.nova.billing.invoice.api.InvoiceDto;
import com.sktelecom.nova.billing.invoice.api.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/billing/invoices")
class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping("/{id}")
    public InvoiceDto getInvoiceById(@PathVariable(name="id") UUID customerId) {
        return invoiceService.getInvoiceById(customerId);
    }

    @GetMapping
    public List<InvoiceDto> getAllInvoices() {
        return invoiceService.findAllInvoices();
    }


}

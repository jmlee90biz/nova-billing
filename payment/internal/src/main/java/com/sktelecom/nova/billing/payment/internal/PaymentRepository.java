package com.sktelecom.nova.billing.payment.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface PaymentRepository extends JpaRepository<Payment, UUID> {
}

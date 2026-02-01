package com.tourvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tourvn.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}


package com.tourvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tourvn.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByBookingId(Long bookingId);

    Payment findTopByBookingIdOrderByIdDesc(Long bookingId);
}


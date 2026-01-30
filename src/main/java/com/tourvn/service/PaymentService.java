package com.tourvn.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.tourvn.entity.Payment;
import com.tourvn.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Payment creatPayment (long bookingId, String method){
        Payment payment = new Payment(
            bookingId,
            100000.0,
            method,
            "pending"
        );
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(long id){
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong tim thay id" +id));
    }
}

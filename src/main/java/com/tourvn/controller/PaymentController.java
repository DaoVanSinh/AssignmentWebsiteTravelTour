package com.tourvn.controller;

import org.springframework.web.bind.annotation.*;
import com.tourvn.dto.PaymentRequest;
import com.tourvn.entity.Payment;
import com.tourvn.service.PaymentService;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentSevice) {
        this.paymentService = paymentSevice;
    }

    @PostMapping
    public Payment createPayment(@RequestBody PaymentRequest request) {

        return paymentService.createPayment(request);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayment();
    }
    
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }
}

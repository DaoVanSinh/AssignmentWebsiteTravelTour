package com.tourvn.controller;

import org.springframework.web.bind.annotation.*;
import com.tourvn.dto.PaymentRequest;
import com.tourvn.entity.Payment;
import com.tourvn.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController (PaymentService paymentSevice){
        this.paymentService = paymentSevice;
    }

    @PostMapping
    public Payment createPayment(@RequestBody PaymentRequest request){

        return paymentService.createPayment(request);
    }
    
    @GetMapping
    public String getAllPayments() {
        return "Get all payments API";
    }

    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable Long id) {
        return "Get payment by id: " + id;
    }
}


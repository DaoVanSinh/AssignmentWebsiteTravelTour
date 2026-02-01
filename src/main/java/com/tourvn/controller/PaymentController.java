package com.tourvn.controller;

import org.springframework.web.bind.annotation.*;

import com.tourvn.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController (PaymentService paymentSevice){
        this.paymentService = paymentSevice;
    }

    // Tạo thanh toán
    @PostMapping("/{bookingId}")
    public String createPayment(
            @PathVariable Long bookingId,
            @RequestParam String method) {

        return "Payment API is working";
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


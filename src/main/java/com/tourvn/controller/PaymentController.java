package com.tourvn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tourvn.dto.PaymentRequest;
import com.tourvn.entity.Payment;
import com.tourvn.repository.PaymentRepository;
import com.tourvn.service.PaymentService;
import com.tourvn.service.VNPayService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

        private final PaymentService paymentService;

        public PaymentController(PaymentService paymentSevice) {
            this.paymentService = paymentSevice;
}

@Autowired
    private VNPayService vnPayService;

@Autowired
    private PaymentRepository paymentRepository;

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

@GetMapping("/vnpay")
    public Map<String, String> createVNPayPayment(
        @RequestParam Long bookingId,
        @RequestParam Double amount) {

    String paymentUrl = vnPayService.createPaymentUrl(bookingId, amount);

    Map<String, String> result = new HashMap<>();
    result.put("paymentUrl", paymentUrl);

    return result;
}

@GetMapping("/vnpay-return")
        public void paymentReturn(@RequestParam Map<String, String> params,
        HttpServletResponse response) throws IOException {

        System.out.println("VNPay params: " + params);

        String responseCode = params.get("vnp_ResponseCode");
        String orderInfo = params.get("vnp_OrderInfo");

    try {

        if ("00".equals(responseCode)) {

            Long bookingId = Long.parseLong(orderInfo.replaceAll("[^0-9]", ""));
            System.out.println("BookingId = " + bookingId);

            Payment payment = paymentRepository
                    .findTopByBookingIdOrderByIdDesc(bookingId);

            if (payment != null) {

                payment.setPaymentStatus("SUCCESS");
                paymentRepository.save(payment);

                System.out.println("Payment updated!");
            }

            response.sendRedirect("http://localhost:5500/frontend/pages/tours.html?payment=success");

        } else {

            response.sendRedirect("http://localhost:5500/frontend/pages/tours.html?payment=fail");

        }

    } catch (Exception e) {

        e.printStackTrace();

        response.sendRedirect("http://localhost:5500/frontend/pages/tours.html?payment=error");

    }
}
}

package com.tourvn.controller;
import com.tourvn.service.BookingService;
import com.tourvn.dto.BookingRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/test-create")
    public String testCreate(@RequestBody BookingRequest request) {
        // Gọi Service rỗng ở trên
        return bookingService.createBooking(request);
    }
}
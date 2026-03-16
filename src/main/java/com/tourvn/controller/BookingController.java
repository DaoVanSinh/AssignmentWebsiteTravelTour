package com.tourvn.controller;

import com.tourvn.service.BookingService;
import com.tourvn.dto.BookingRequest;
import com.tourvn.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }
}
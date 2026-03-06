package com.tourvn.controller;

import com.tourvn.service.BookingService;

import jakarta.validation.Valid;

import com.tourvn.dto.BookingRequest;
import com.tourvn.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController       //Bộ điều khiển API
@RequestMapping("/api/bookings")      //URL cho bookings
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
public ResponseEntity<Booking> createBooking(@Valid @RequestBody BookingRequest request) {
    Booking booking = bookingService.createBooking(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(booking);
}

    @GetMapping("/{id}")
public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
    Booking booking = bookingService.getBookingById(id);
    return ResponseEntity.ok(booking);
}

    @PutMapping("/{id}/cancel")
    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
        try {
            Booking booking = bookingService.cancelBooking(id);
            return ResponseEntity.ok(booking);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/customer/{email}")
public ResponseEntity<?> getBookingsByCustomer(@PathVariable String email) {
    try {
        List<Booking> bookings = bookingService.getBookingsByEmail(email);
        return ResponseEntity.ok(bookings);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi: " + e.getMessage());
    }
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
    List<Booking> bookings = bookingService.getAllBookings();
    return ResponseEntity.ok(bookings);
}
}
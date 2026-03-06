package com.tourvn.service;

import com.tourvn.dto.BookingRequest;
import com.tourvn.entity.Booking;
import java.util.List;
public interface BookingService {
    Booking createBooking(BookingRequest request);

    Booking getBookingById(Long id);

    Booking cancelBooking(Long id);

    List<Booking> getBookingsByEmail(String email);

    List<Booking> getAllBookings();
}
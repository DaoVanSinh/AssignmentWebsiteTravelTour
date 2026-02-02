package com.tourvn.service;

import com.tourvn.dto.BookingRequest;
import com.tourvn.entity.Booking;
public interface BookingService {
    Booking createBooking(BookingRequest request);

    Booking getBookingById(Long id);
}
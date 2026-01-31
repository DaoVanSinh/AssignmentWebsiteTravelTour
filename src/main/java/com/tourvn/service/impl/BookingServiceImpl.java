package com.tourvn.service.impl;

import com.tourvn.dto.BookingRequest;
import com.tourvn.entity.Booking;
import com.tourvn.entity.BookingStatus;
import com.tourvn.repository.BookingRepository;
import com.tourvn.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(BookingRequest request) {

        Booking booking = new Booking();

        booking.setCustomerName(request.getCustomerName());
        booking.setPhone(request.getPhone());
        booking.setEmail(request.getEmail());
        booking.setTourId(request.getTourId());
        booking.setNumberOfPeople(request.getNumberOfPeople());

        booking.setStatus(BookingStatus.CREATED);
        booking.setBookingDate(LocalDateTime.now());

        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
}

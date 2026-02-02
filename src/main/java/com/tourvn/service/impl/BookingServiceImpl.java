package com.tourvn.service.impl;

import com.tourvn.dto.BookingRequest;
import com.tourvn.entity.Booking;
import com.tourvn.entity.BookingStatus;
import com.tourvn.repository.BookingRepository;
import com.tourvn.repository.TourRepository;
import com.tourvn.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourvn.entity.Tour;
import java.time.LocalDateTime;

@Service    //tầng xử lý logic
public class BookingServiceImpl implements BookingService {

    @Autowired     //lưu database
    private BookingRepository bookingRepository;

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Booking createBooking(BookingRequest request) {    // hàm xử lý tạo booking

        Tour tour = tourRepository.findById(request.getTourId()).orElse(null);
        if (tour == null) {
            throw new IllegalArgumentException("Tour not found");
        }

        Booking booking = new Booking();  // tạo đối tượng booking

        booking.setCustomerName(request.getCustomerName());    //gán tên client gọi dữ liệu từ request
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

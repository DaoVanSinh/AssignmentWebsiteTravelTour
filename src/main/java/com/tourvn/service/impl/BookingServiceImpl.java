package com.tourvn.service.impl;

import com.tourvn.dto.BookingRequest;
import com.tourvn.entity.Booking;
import com.tourvn.entity.BookingStatus;
import com.tourvn.repository.BookingRepository;
import com.tourvn.repository.TourRepository;
import com.tourvn.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourvn.entity.Tour;
import java.time.LocalDateTime;
import java.util.List;

@Service    //tầng xử lý logic
public class BookingServiceImpl implements BookingService {

    @Autowired     //lưu database
    private BookingRepository bookingRepository;

    @Autowired
    private TourRepository tourRepository;

    @Override
    @Transactional
    public Booking createBooking(BookingRequest request) {    // hàm xử lý tạo booking

        Tour tour = tourRepository.findById(request.getTourId()).orElse(null);
        if (tour == null) {
            throw new IllegalArgumentException("Khong tim thay tour voi ID: " + request.getTourId());
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
        return bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Khong tim thay booking voi ID: " + id));
    }
    @Override
    @Transactional
    public Booking cancelBooking(Long id) {
        // 1. Tìm booking
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Khong tim thay booking voi ID: " + id));

        // 2. Kiểm tra trạng thái
        if (booking.getStatus() == BookingStatus.CANCELLED) {
            throw new IllegalArgumentException("Booking da bi huy truoc do");
        }

        if (booking.getStatus() == BookingStatus.PAID) {
            throw new IllegalArgumentException(
                "Khong the huy booking da thanh toan. Vui long lien he ho tro.");
        }

        // 3. Cập nhật trạng thái
        booking.setStatus(BookingStatus.CANCELLED);

        // 4. Lưu lại
        return bookingRepository.save(booking);
    }
    
    @Override
    public List<Booking> getBookingsByEmail(String email) {
        return bookingRepository.findByEmailOrderByBookingDateDesc(email);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
}
}

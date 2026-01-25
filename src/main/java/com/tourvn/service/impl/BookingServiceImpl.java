package com.tourvn.service.impl;

import com.tourvn.service.BookingService;
import com.tourvn.dto.BookingRequest;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public String createBooking(BookingRequest request) {
        // Tạm thời chưa gọi Repository, chỉ trả về chuỗi xác nhận giả
        return "Bạn đã đặt tour thành công cho: " + request.getFullName() + 
               " với số lượng: " + request.getAdults() + " người lớn.";
    }
}
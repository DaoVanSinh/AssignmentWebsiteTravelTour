package com.tourvn.service;

import com.tourvn.dto.BookingRequest;
public interface BookingService {
    String createBooking(BookingRequest request); // Trả về câu thông báo hoặc ID đơn hàng
}
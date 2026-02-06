package com.tourvn.repository;

import com.tourvn.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository   // tầng làm việc với database
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByEmailOrderByBookingDateDesc(String email);
}

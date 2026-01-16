package com.tourvn.entity;
import jakarta.persistence.*;
import jakarta.annotation.Generated;
import java.time.LocalDateTime;

@Entity 
@Table(name = "bookings")

public class Booking {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String phone;
    private String email;

    private Long tourId;
    private int numberOfPeoPle;

    private LocalDateTime bookingDate;
    private String status;

}

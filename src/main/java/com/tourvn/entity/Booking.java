package com.tourvn.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id // khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    private String phone;

    private String email;

    @Column(name = "tour_id", nullable = false)
    private Long tourId;

    @Column(name = "number_of_people", nullable = false)
    private int numberOfPeople;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "special_request")
    private String specialRequest;

    @Enumerated(EnumType.STRING) //trạng thái booking lưu dưới dạng text
    private BookingStatus status;

    // ===== GETTER & SETTER =====

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getStatus() { 
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }
    
    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
}

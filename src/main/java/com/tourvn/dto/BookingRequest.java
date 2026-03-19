package com.tourvn.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

public class BookingRequest {

    @NotBlank(message = "Tên khách hàng không được để trống")
    @Size(min = 2, max = 100, message = "Tên phải từ 2-100 ký tự")
        private String customerName;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải có 10 số và bắt đầu bằng 0 ")
        private String phone;


    @Email(message = "Email không đúng định dạng")
        private String email;


    @NotNull(message = "Tour ID không được để trống")
    @Positive(message = "Tour ID phải là số dương")
            private Long tourId;


    @Min(value = 1, message = "Số người phải ít nhất 1")
    @Max(value = 50, message = "Số người tối đa 50")
        private int numberOfPeople;
        
        private String specialRequest;
        private LocalDate departureDate;
        private int adultQuantity;
        private int childQuantity;
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public LocalDate getDepartureDate() {
    return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
    this.departureDate = departureDate;
    }

    public int getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(int adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public int getChildQuantity() {
        return childQuantity;
    }

    public void setChildQuantity(int childQuantity) {
        this.childQuantity = childQuantity;
    }

}
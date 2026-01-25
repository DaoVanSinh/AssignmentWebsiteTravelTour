package com.tourvn.dto;
import lombok.Data;

@Data // Dùng Lombok để tự tạo Getter/Setter
public class BookingRequest {
    private Long tourId;
    private String fullName;
    private String email;
    private int adults;
    private int children;
    private String note;
}
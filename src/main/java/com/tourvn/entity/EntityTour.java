package com.tourvn.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "entity_tour")
public class EntityTour {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;       //idTour khóa chính
    private String destination;   // điểm đến
    private Double price;         // giá tiền
    private int  durationDays; // số ngày diễn ra
    private String description;   // mô tả tour
   private LocalDate startDay; //ngày bắt đầu 
    private LocalDate endDay; //ngày kết thúc
    private String hotelName;    //tên khách sạn dừng chân
    private int availableSeats; //số chỗ còn trống
    private String transport; //phương tiện di chuyển

   
}

package com.tourvn.repository;
import com.tourvn.entity.EntityTour;
import org.springframework.data.jpa.repository.JpaRepository; 
import java.util.List;

public interface RepositoryTour extends JpaRepository<EntityTour, Long> {
    //Lọc theo điểm đến 
        List<EntityTour> findByDestination(String destination);

    // Lọc theo giá nhỏ hơn một mức
    List<EntityTour> findByPriceLessThan(Double price);

    // Lọc theo số ngày
 List<EntityTour> findByDurationDays(Integer durationDays);

    // Lọc linh hoạt theo cả 3 điều kiện
    List<EntityTour> findByDestinationAndPriceLessThanAndDurationDays(
            String destination, Double price, Integer durationDays);

    // Nếu muốn hỗ trợ lọc theo 2 điều kiện bất kỳ
    List<EntityTour> findByDestinationAndPriceLessThan(String destination, Double price);
    List<EntityTour> findByDestinationAndDurationDays(String destination, Integer durationDays);
    List<EntityTour> findByPriceLessThanAndDurationDays(Double price, Integer durationDays);


}

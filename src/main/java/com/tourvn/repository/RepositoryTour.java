package com.tourvn.repository;
import com.tourvn.Utils.utils;
import com.tourvn.entity.EntityTour;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryTour extends JpaRepository<EntityTour, Long> {
    //Lọc theo điểm đến 
        List<EntityTour> findByDestination(String destination);

    // Lọc theo giá nhỏ hơn một mức
    List<EntityTour> findByPriceLessThan(Double price);

    // Lọc theo số ngày diễn ra tour
 List<EntityTour> findByDurationDays(Integer durationDays);

    // Lọc linh hoạt theo cả 3 điều kiện
    List<EntityTour> findByDestinationAndPriceLessThanAndDurationDays(
            String destination, Double price, Integer durationDays);

    // Nếu muốn hỗ trợ lọc theo 2 điều kiện bất kỳ
    List<EntityTour> findByDestinationAndPriceLessThan(String destination, Double price);
    List<EntityTour> findByDestinationAndDurationDays(String destination, Integer durationDays);
    List<EntityTour> findByPriceLessThanAndDurationDays(Double price, Integer durationDays);

    //Tìm kiếm theo tiêu chí
    @Query("""
            Select t From EntityTour t
            where lower(t.nameTourNoAccent) LIKE  lower(concat('%',:keyword,'%'))
            OR lower(t.destinationNoAccent) LIKE lower(concat('%',:keyword,'%'))
            OR lower(t.descriptionNoAccent) LIKE lower(concat('%',:keyword,'%'))
             """)
            List<EntityTour> searchByKeyWord(@Param("keyword") String keyword);
    }


package com.tourvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tourvn.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByTourId(Long tourId);
}


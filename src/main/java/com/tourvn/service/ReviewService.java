package com.tourvn.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import com.tourvn.entity.Review;
import com.tourvn.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Long tourId, String email, int rating, String comment) {

        if (rating < 1 || rating > 5) {
            throw new RuntimeException("số sao phải từ 1 đến 5");
        }

        Review review = new Review(tourId,userId, email, rating, comment);
        review.setReviewDate(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByTour(Long tourId) {
        return reviewRepository.findByTourId(tourId);
    }
}

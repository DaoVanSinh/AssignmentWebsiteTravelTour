package com.tourvn.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.tourvn.dto.ReviewRequest;
import com.tourvn.entity.Review;
import com.tourvn.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review createReview(@RequestBody ReviewRequest request) {
        return reviewService.createReview(
                request.getTourId(),
                request.getUserId(),
                request.getEmail(),
                request.getRating(),
                request.getComment());
    }

    @GetMapping("/tour/{tourId}")
    public List<Review> getReviewsByTour(@PathVariable Long tourId) {

        return reviewService.getReviewsByTour(tourId);
    }
}

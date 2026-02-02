package com.tourvn.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    // Dependency Injection ReviewService 
    
    @PostMapping("/{bookingId}")
    public String createReview(
            @PathVariable Long bookingId,
            @RequestParam int rating,
            @RequestParam String comment) {

        return "Review API is working";
    }

    @GetMapping("/tour/{tourId}")
    public String getReviewsByTour(@PathVariable Long tourId) {
        return "Get reviews for tour: " + tourId;
    }
}


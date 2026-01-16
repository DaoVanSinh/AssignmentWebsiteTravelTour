package com.tourvn.controller;

import com.tourvn.entity.Tour;
import com.tourvn.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourRepository tourRepository;

    @GetMapping
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return tourRepository.save(tour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour tourDetails) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tour với id: " + id));

        tour.setTitle(tourDetails.getTitle());
        tour.setDescription(tourDetails.getDescription());
        tour.setPrice(tourDetails.getPrice());
        tour.setImageUrl(tourDetails.getImageUrl());

        Tour updatedTour = tourRepository.save(tour);
        return ResponseEntity.ok(updatedTour);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tour với id: " + id));

        tourRepository.delete(tour);
        return ResponseEntity.ok("Đã xóa Tour thành công!");
    }
}
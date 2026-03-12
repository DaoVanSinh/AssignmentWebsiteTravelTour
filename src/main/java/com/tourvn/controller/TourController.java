package com.tourvn.controller;

import com.tourvn.entity.Tour;
import com.tourvn.repository.TourRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/tours")
@CrossOrigin(origins = "*")
public class TourController {

    @Autowired
    private TourRepository tourRepository;

    // API lấy danh sách tour
    @GetMapping
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @GetMapping("/api/admin/tours/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {

    Tour tour = tourRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy tour"));

    return ResponseEntity.ok(tour);
}

    // Admin: thêm tour
    @PostMapping("/api/admin/tours")
    public Tour createTour(@RequestBody Tour tour) {
        return tourRepository.save(tour);
    }

    // Admin: cập nhật tour
    @PutMapping("/admin/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour tourDetails) {

        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tour với id: " + id));

        tour.setName(tourDetails.getName());
        tour.setDescription(tourDetails.getDescription());
        tour.setPrice(tourDetails.getPrice());
        tour.setStartDate(tourDetails.getStartDate());
        tour.setEndDate(tourDetails.getEndDate());
        tour.setMaxPeople(tourDetails.getMaxPeople());
        tour.setImageUrl(tourDetails.getImageUrl());

        Tour updatedTour = tourRepository.save(tour);

        return ResponseEntity.ok(updatedTour);
    }

    // Admin: xóa tour
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) {

        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tour với id: " + id));

        tourRepository.delete(tour);

        return ResponseEntity.ok("Đã xóa Tour thành công!");
    }
}
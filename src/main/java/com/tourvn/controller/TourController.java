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

    // API lấy danh sách TẤT CẢ tour (Vẫn cần để hiển thị lên bảng)
    @GetMapping
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    // API xem chi tiết 1 tour (MỚI THÊM theo ảnh)
    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tour với id: " + id));
        return ResponseEntity.ok(tour);
    }

    // Admin: thêm tour
    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return tourRepository.save(tour);
    }

    // Admin: cập nhật tour

    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour tourDetails) {

        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tour với id: " + id));

        tour.setTitle(tourDetails.getTitle());
        tour.setDescription(tourDetails.getDescription());
        tour.setDuration(tourDetails.getDuration());
        tour.setDeparture(tourDetails.getDeparture());
        tour.setStartDate(tourDetails.getStartDate());
        tour.setAdultPrice(tourDetails.getAdultPrice());
        tour.setChildPrice(tourDetails.getChildPrice());
        tour.setImageUrl(tourDetails.getImageUrl());

        Tour updatedTour = tourRepository.save(tour);

        return ResponseEntity.ok(updatedTour);
    }

    // Admin: xóa tour

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) {

        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tour với id: " + id));

        tourRepository.delete(tour);

        return ResponseEntity.ok("Đã xóa Tour thành công!");
    }
}
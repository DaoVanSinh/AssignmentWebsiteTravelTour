package com.tourvn.controller;

import com.tourvn.entity.Tour;
import com.tourvn.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tours") 
@CrossOrigin("*")
public class TourPublicController {

    @Autowired
    private TourService tourService;


    @GetMapping
    public List<Tour> getPublicTours() {
        return tourService.getAllTours();
    }
}
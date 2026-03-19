package com.tourvn.controller;

import com.tourvn.dto.DtoSearchAndFilter;
import com.tourvn.entity.EntityTour;
import com.tourvn.service.ServiceTour;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/tours")
public class ControllerTour {
    private final ServiceTour tourService;

    public ControllerTour(ServiceTour tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public Page<EntityTour> getTour(
            // search--filter
            @Valid DtoSearchAndFilter dto,
            // page
            @PageableDefault(size = 10, sort = "price", direction = Sort.Direction.DESC) Pageable pageable) {
        return tourService.searchAndFilter(dto, pageable);
    }

}

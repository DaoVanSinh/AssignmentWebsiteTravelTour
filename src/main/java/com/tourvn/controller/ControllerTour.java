    package com.tourvn.controller;
    import com.tourvn.entity.EntityTour;
    import com.tourvn.service.ServiceTour;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;
    import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @RestController
    @RequestMapping("/api/tours")
    public class ControllerTour {
        private final ServiceTour tourService;
 public ControllerTour(ServiceTour tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/search")
    public List<EntityTour> searchFlexible(@RequestParam(required = false) String destination,
                                @RequestParam(required = false) Double price,
                                @RequestParam(required = false) Integer days) {
        return tourService.searchFlexible(destination, price, days);
    }

    @GetMapping("/pageable")
    public Page<EntityTour> getToursPaged(@RequestParam(defaultValue="0") int page){
             return tourService.getTourPageAndSort(page);
    }
    }
    

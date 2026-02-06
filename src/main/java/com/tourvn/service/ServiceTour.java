package com.tourvn.service;

import com.tourvn.DTO.DtoSearchAndFilter;
import com.tourvn.Utils.utils;
import com.tourvn.entity.EntityTour;
import com.tourvn.repository.RepositoryTour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tourvn.Specification.TourSpec;
 
@Service
public class ServiceTour {

   private final RepositoryTour repositoryTour; 
   public ServiceTour(RepositoryTour repositoryTour) {
        this.repositoryTour = repositoryTour;
    }

//search--filter--page
    public Page<EntityTour> searchAndFilter(DtoSearchAndFilter dto,Pageable pageable) {
        validatePrice(dto.getMinPrice(),dto.getMaxPrice());
        Specification<EntityTour> spec =  TourSpec.buildSpec(dto);

            return repositoryTour.findAll(spec,pageable);
    }
    private void validatePrice(Double min, Double max){
        if(min!=null && max!=null
        &&min>max){
        throw new IllegalArgumentException(
            "Giá tối thiểu phải nhỏ hơn hoặc bằng giá tối đa");
        }
    }
}
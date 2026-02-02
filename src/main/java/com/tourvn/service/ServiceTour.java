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
 
@Service
public class ServiceTour {

   private final RepositoryTour repositoryTour; 
    // Khai báo repository với tên mới
   public ServiceTour(RepositoryTour repositoryTour) {
        this.repositoryTour = repositoryTour;
    }

//search--filter--page
    public Page<EntityTour> searchAndFilter(DtoSearchAndFilter dto,Pageable pageable) {
        Specification<EntityTour> spec =  Specification.where(null);
         if (dto.getKeyword()!= null && !dto.getKeyword().trim().isEmpty()) {
             String nameNoAccent=utils.removeAccent(dto.getKeyword())
             .toLowerCase()
             .trim();
        spec = spec.and((root, query, cb) ->    
        cb.or(
            cb.like(root.get("nameTourNoAccent"), "%" + nameNoAccent + "%"),
            cb.like(root.get("destinationNoAccent"),"%"+nameNoAccent+"%"),
            cb.like(root.get("descriptionNoAccent"),"%"+nameNoAccent+"%")
        )
        );
    }
    if(dto.getMinPrice()!=null){
        spec =spec.and((root,query,cb)->
        cb.greaterThanOrEqualTo(root.get("price"),dto.getMinPrice())
    );
    if(dto.getMaxPrice()!=null){
        spec=spec.and((root,query,cb)->
       cb.lessThanOrEqualTo(root.get("price"),dto.getMaxPrice())
    );
    }
    }
    if(dto.getDays()!=null){
        spec=spec.and((root,query,cb)->
        cb.equal(root.get("durationDays"),dto.getDays())
    );
    }
    return  repositoryTour.findAll(spec,pageable);
    }
}
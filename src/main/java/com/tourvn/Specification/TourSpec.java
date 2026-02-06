package com.tourvn.Specification;

import com.tourvn.DTO.DtoSearchAndFilter;
import com.tourvn.Utils.utils;
import com.tourvn.entity.EntityTour;
import org.springframework.data.jpa.domain.Specification;
public class TourSpec {
    public static Specification<EntityTour> buildSpec(DtoSearchAndFilter dto){
        Specification<EntityTour> spec=Specification.where(null);
        //keyword 
        if(dto.getKeyword()!=null&& !dto.getKeyword().trim().isEmpty()){
            String keyword=utils.removeAccent(dto.getKeyword()).toLowerCase().trim();
            spec=spec.and((root,query,cb)->
            cb.or(
                cb.like(root.get("nameTourNoAccent"),"%" +keyword+ "%"),
                cb.like(root.get("destinationNoAccent"),"%" +keyword+ "%"),
                cb.like(root.get("descriptionNoAccent"),"%"+ keyword + "%" )
            )
        );
        }
        //minPrice
        if(dto.getMinPrice()!=null){
            spec=spec.and((root,query,cb)->
            cb.greaterThanOrEqualTo(root.get("price"),dto.getMinPrice())
        );
        }
        //maxPrice
        if(dto.getMaxPrice()!=null){
            spec=spec.and((root,quere,cb)->
            cb.lessThanOrEqualTo(root.get("price"),dto.getMaxPrice())
        );
        }

        //days
        if(dto.getDays()!=null){
            spec=spec.and((root,query,cb)->
            cb.equal(root.get("durationDays"),dto.getDays())
        );
        }
        return spec;
    }
}

package com.tourvn.service;

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

//Lọc tour theo tiêu chí
    public List<EntityTour> searchFlexible(String nameTourKeyword, Double priceKeyword, Integer daysKeyword) {
        Specification<EntityTour> spec =  Specification.where(null);
        String nameNoAccent=utils.removeAccent(nameTourKeyword).toLowerCase().trim();
         if (nameTourKeyword != null && !nameTourKeyword.trim().isEmpty()) {
        spec = spec.and((root, query, cb) ->
                cb.like(root.get("nameTourNoAccent"), "%" + nameNoAccent + "%")
        );
    }
    if(priceKeyword!=null){
        spec =spec.and((root,query,cb)->
        cb.lessThan(root.get("price"),priceKeyword)
    );
    }
    if(daysKeyword!=null){
        spec=spec.and((root,query,cb)->
        cb.equal(root.get("durationDays"),daysKeyword)
    );
    }
    return  repositoryTour.findAll(spec);
    }
    //Phân trang size 10
    public Page<EntityTour> getTourPageAndSort(int page){
        Pageable pageable= PageRequest.of(page,10,Sort.by("price").descending());
        return repositoryTour.findAll(pageable);
    }
    //Tìm kiếm theo keyword không dấu
    public List<EntityTour> search(String keyword){
        if(keyword==null||keyword.trim().isEmpty()){
            return repositoryTour.findAll();
        }
        String temp= utils.removeAccent(keyword);
        return repositoryTour.searchByKeyWord(temp);

    }

}

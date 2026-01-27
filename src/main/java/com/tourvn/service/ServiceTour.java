package com.tourvn.service;

import com.tourvn.Utils.utils;
import com.tourvn.entity.EntityTour;
import com.tourvn.repository.RepositoryTour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public List<EntityTour> searchFlexible(String destination, Double price, Integer days) {
        if (destination != null && price != null && days != null) {
            return repositoryTour.findByDestinationAndPriceLessThanAndDurationDays(destination, price, days);
        } else if (destination != null && price != null) {
            return repositoryTour.findByDestinationAndPriceLessThan(destination, price);
        } else if (destination != null && days != null) {
            return repositoryTour.findByDestinationAndDurationDays(destination, days);
        } else if (price != null && days != null) {
            return repositoryTour.findByPriceLessThanAndDurationDays(price, days);
        } else if (destination != null) {
            return repositoryTour.findByDestination(destination);
        } else if (price != null) {
            return repositoryTour.findByPriceLessThan(price);
        } else if (days != null) {
            return repositoryTour.findByDurationDays(days);
        } else {
            return repositoryTour.findAll(); // nếu không nhập gì thì trả về tất cả
        }
    }
    //Phân trang size 10
    public Page<EntityTour> getTourPageAndSort(int page){
        Pageable pageable= PageRequest.of(page,10,Sort.by("price").descending());
        return repositoryTour.findAll(pageable);
    }
    //Tìm kiếm theo tiêu chí
    public List<EntityTour> search(String keyword){
        if(keyword==null||keyword.trim().isEmpty()){
            return repositoryTour.findAll();
        }
        String temp= utils.removeAccent(keyword);
        return repositoryTour.searchByKeyWord(temp);

    }

}

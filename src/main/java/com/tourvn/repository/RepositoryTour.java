package com.tourvn.repository;

import com.tourvn.entity.EntityTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryTour
        extends JpaRepository<EntityTour, Long>,
                JpaSpecificationExecutor<EntityTour> {
    // Tìm kiếm theo keyword không dấu
    @Query("""
        select t from EntityTour t
        where lower(t.nameTourNoAccent) like lower(concat('%', :keyword, '%'))
        or lower(t.destinationNoAccent) like lower(concat('%', :keyword, '%'))
        or lower(t.descriptionNoAccent) like lower(concat('%', :keyword, '%'))
    """)
    List<EntityTour> searchByKeyWord(@Param("keyword") String keyword);
}

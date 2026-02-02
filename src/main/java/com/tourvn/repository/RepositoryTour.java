package com.tourvn.repository;

import com.tourvn.entity.EntityTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryTour
        extends JpaRepository<EntityTour, Long>,
                JpaSpecificationExecutor<EntityTour> {}

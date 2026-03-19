package com.tourvn.repository;

import com.tourvn.entity.EntityTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositoryTour
        extends JpaRepository<EntityTour, Long>,
                JpaSpecificationExecutor<EntityTour> {}

package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {

    Catalogue findCatalogueByNameContainingIgnoreCase(String name);

}

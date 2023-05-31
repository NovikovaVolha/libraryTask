package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {

    List<Catalogue> findCataloguesByNameContainingIgnoreCase(String name);

    Catalogue findCatalogueByName(String name);

}

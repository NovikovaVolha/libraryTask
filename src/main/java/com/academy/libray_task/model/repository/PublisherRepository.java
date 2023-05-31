package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    List<Publisher> findPublishersByNameContainingIgnoreCase(String name);

    List<Publisher> findPublishersByCountryContainingIgnoreCase(String country);

    Publisher findPublisherByName(String name);

}

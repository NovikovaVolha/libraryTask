package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findCategoryByNameContainingIgnoreCase(String name);
    Page<Category> findAll(Pageable pageable);

}

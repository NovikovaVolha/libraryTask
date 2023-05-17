package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findCategoryByNameContainingIgnoreCase(String name);

}

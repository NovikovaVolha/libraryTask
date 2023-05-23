package com.academy.libray_task.service;

import com.academy.libray_task.dto.CategoryDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    void save(CategoryDto category);

    List<CategoryDto> findAll();

    Page<CategoryDto> findAllPaginated(Integer pageNumber, Integer pageSize);

    CategoryDto findById(Integer id);

    List<CategoryDto> findByName(String name);

    void delete(Integer id);

}

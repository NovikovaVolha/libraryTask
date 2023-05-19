package com.academy.libray_task.service.impl;

import com.academy.libray_task.dto.CategoryDto;
import com.academy.libray_task.mapper.CategoryMapper;
import com.academy.libray_task.model.entity.Category;
import com.academy.libray_task.model.repository.CategoryRepository;
import com.academy.libray_task.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void save(CategoryDto category) {
        categoryRepository.save(categoryMapper.toEntity(category));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    @Override
    public List<CategoryDto> findAllPaginated(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id");
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categoryMapper.toDtoList(categories.getContent());
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryMapper.toDto(categoryRepository.getReferenceById(id));
    }

    @Override
    public List<CategoryDto> findByName(String name) {
        return categoryMapper.toDtoList(categoryRepository.findCategoryByNameContainingIgnoreCase(name));
    }

    @Override
    public void delete(CategoryDto category) {
        categoryRepository.delete(categoryMapper.toEntity(category));
    }

}

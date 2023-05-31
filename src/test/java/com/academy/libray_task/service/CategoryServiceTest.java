package com.academy.libray_task.service;

import com.academy.libray_task.dto.CategoryDto;
import com.academy.libray_task.mapper.CategoryMapper;
import com.academy.libray_task.model.entity.Category;
import com.academy.libray_task.model.repository.CategoryRepository;
import com.academy.libray_task.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;
    private Category category;
    private CategoryDto categoryDto;

    @BeforeEach
    void init() {
        category = new Category();
        category.setId(1);
        category.setName("name");

        categoryDto = new CategoryDto();
        categoryDto.setId(1);
        categoryDto.setName("name");
    }

    @Test
    void findAll_shouldReturnAuthorsList_thenCorrect() {
        List<Category> categories = Collections.singletonList(category);
        when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDto> categoriesDto = Collections.singletonList(categoryDto);
        when(categoryMapper.toDtoList(categories)).thenReturn(categoriesDto);

        List<CategoryDto> actual = categoryService.findAll();
        verify(categoryRepository).findAll();
        verify(categoryMapper).toDtoList(categories);
        assertEquals(categoriesDto, actual);
    }

    @Test
    void findByName_shouldReturnAuthorsList_thenCorrect() {
        List<Category> categories = Collections.singletonList(category);
        when(categoryRepository.findCategoryByNameContainingIgnoreCase("name")).thenReturn(categories);

        List<CategoryDto> expected = categoryMapper.toDtoList(categories);
        when(categoryService.findByName("name")).thenReturn(expected);

        List<CategoryDto> actual = categoryService.findByName("name");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void delete_shouldDeleteAuthor_thenCorrect() {
        Integer id = 1;
        categoryService.delete(id);
        verify(categoryRepository, times(1)).deleteById(id);
    }

}

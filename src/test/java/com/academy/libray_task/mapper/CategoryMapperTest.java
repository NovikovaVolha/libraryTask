package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.CategoryDto;
import com.academy.libray_task.model.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryMapperTest {

    private final CategoryMapper categoryMapper = new CategoryMapperImpl();
    private Category entity;
    private CategoryDto dto;

    @BeforeEach
    void init() {
        entity = Category.builder()
                .name("Category")
                .build();

        dto = CategoryDto.builder()
                .name("CategoryDto")
                .build();
    }

    @Test
    void toDto_shouldMapEntityToDto_thenCorrect() {
        CategoryDto mappedDto = categoryMapper.toDto(entity);

        assertEquals(entity.getName(), mappedDto.getName());
    }

    @Test
    void toDto_shouldMapDtoToEntity_thenCorrect() {
        Category mappedEntity = categoryMapper.toEntity(dto);

        assertEquals(dto.getName(), mappedEntity.getName());
    }

    @Test
    void toDtoList_shouldMapEntityListToDtoList_thenCorrect() {
        List<Category> entityList = Collections.singletonList(entity);

        List<CategoryDto> dtoList = categoryMapper.toDtoList(entityList);

        assertNotNull(dtoList);
        assertEquals(1, dtoList.size());
        assertEquals(entity.getName(), dtoList.get(0).getName());
    }

    @Test
    void toDtoList_shouldMapDtoListToEntityList_thenCorrect() {
        List<CategoryDto> dtoList = Collections.singletonList(dto);

        List<Category> entityList = categoryMapper.toEntityList(dtoList);

        assertNotNull(entityList);
        assertEquals(1, entityList.size());
        assertEquals(dto.getName(), entityList.get(0).getName());
    }

}

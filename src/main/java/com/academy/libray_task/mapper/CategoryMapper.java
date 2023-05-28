package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.CategoryDto;
import com.academy.libray_task.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<Category> categories);

    List<Category> toEntityList(List<CategoryDto> categories);



//    String toStringFromEntity(Category category);
//    Category toEntityFromString(String category);
//    List<String> toStringFromEntity(List<Category> categories);
//    List<Category> toEntityFromString(List<String> categories);
//
//    @Named("categoryToString")
//    default String toStringFromDto(CategoryDto categoryDto) {
//        return categoryDto.getName();
//    }
//    @Named("stringToCategory")
//    default CategoryDto toDtoFromString(String category) {
//        String[] parts = category.split(" ");
//        return CategoryDto.builder()
//                .name(parts[0])
//                .build();
//    }
//    List<String> toStringFromDto(List<CategoryDto> categories);
//    List<CategoryDto> toDtoFromString(List<String> categories);

}

package com.academy.libray_task.converter;

import com.academy.libray_task.dto.CategoryDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCategoryDtoConverter implements Converter<String, CategoryDto> {

    @Override
    public CategoryDto convert(String source) {
        CategoryDto categoryDto = new CategoryDto();
        String[] parts = source.split("=");

        categoryDto.setName(parts[1]);

        return categoryDto;
    }

}

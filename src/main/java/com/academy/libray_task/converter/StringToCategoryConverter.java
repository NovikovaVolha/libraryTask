package com.academy.libray_task.converter;

import com.academy.libray_task.model.entity.Category;
import com.academy.libray_task.model.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StringToCategoryConverter implements Converter<String, List<Category>> {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> convert(String source) {
        List<Category> categories = new ArrayList<>();

        if (source.contains(",")){
            String[] parts = source.split(",");

            for (String part:parts) {
                categories.addAll(categoryRepository.findCategoryByNameContainingIgnoreCase(part));
            }
        } else {
            categories.addAll(categoryRepository.findCategoryByNameContainingIgnoreCase(source));
        }

        return categories;
    }

}

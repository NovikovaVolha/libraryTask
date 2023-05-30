package com.academy.libray_task.converter;

import com.academy.libray_task.model.entity.Catalogue;
import com.academy.libray_task.model.repository.CatalogueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StringToCatalogueConverter implements Converter<String, Catalogue> {

    private final CatalogueRepository catalogueRepository;

    @Override
    public Catalogue convert(String source) {

        return catalogueRepository.findCataloguesByNameContainingIgnoreCase(source).get(0);
    }

}

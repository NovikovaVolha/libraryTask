package com.academy.libray_task.converter;

import com.academy.libray_task.dto.CatalogueDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCatalogueDtoConverter implements Converter<String, CatalogueDto> {

    @Override
    public CatalogueDto convert(String source) {
        CatalogueDto catalogueDto = new CatalogueDto();
        String[] parts = source.split("=");

        catalogueDto.setName(parts[1]);

        return catalogueDto;
    }

}

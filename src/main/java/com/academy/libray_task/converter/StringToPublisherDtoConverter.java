package com.academy.libray_task.converter;

import com.academy.libray_task.dto.PublisherDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPublisherDtoConverter implements Converter<String, PublisherDto> {

    @Override
    public PublisherDto convert(String source) {
        PublisherDto publisherDto = new PublisherDto();
        String[] parts = source.split("=");

        String[] nameAndCountry = parts[1].split(", ");

        publisherDto.setName(nameAndCountry[0]);
        publisherDto.setCountry(nameAndCountry[1]);

        return publisherDto;
    }

}

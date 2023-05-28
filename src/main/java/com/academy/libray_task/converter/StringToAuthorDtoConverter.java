package com.academy.libray_task.converter;

import com.academy.libray_task.dto.AuthorDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToAuthorDtoConverter implements Converter<String, AuthorDto> {

    @Override
    public AuthorDto convert(String source) {
        AuthorDto authorDto = new AuthorDto();
        String[] parts = source.split("=");

        String[] nameAndSurname = parts[1].split(" ");

        authorDto.setName(nameAndSurname[0]);
        authorDto.setSurname(nameAndSurname[1]);

        return authorDto;
    }



}

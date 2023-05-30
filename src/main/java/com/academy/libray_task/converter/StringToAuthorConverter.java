package com.academy.libray_task.converter;

import com.academy.libray_task.model.entity.Author;
import com.academy.libray_task.model.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StringToAuthorConverter implements Converter<String, List<Author>> {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> convert(String source) {
        List<Author> authors = new ArrayList<>();

        if (source.contains(",")){
            String[] parts = source.split(",");

            for (String part : parts) {
                String[] nameAndSurname = part.split(" ");
                authors.addAll(authorRepository.findAuthorBySurnameContainingIgnoreCase(nameAndSurname[1]));
            }
        } else {
            String[] nameAndSurname = source.split(" ");
            authors.addAll(authorRepository.findAuthorBySurnameContainingIgnoreCase(nameAndSurname[1]));
        }

        return authors;
    }

}

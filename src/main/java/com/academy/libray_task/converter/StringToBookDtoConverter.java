package com.academy.libray_task.converter;

import com.academy.libray_task.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StringToBookDtoConverter implements Converter<String, BookDto> {

    private final StringToAuthorDtoConverter stringToAuthorDtoConverter;
    private final StringToCatalogueDtoConverter stringToCatalogueDtoConverter;
    private final StringToCategoryDtoConverter stringToCategoryDtoConverter;
    private final StringToPublisherDtoConverter stringToPublisherDtoConverter;

    @Override
    public BookDto convert(String source) {
        BookDto bookDto = new BookDto();

        String[] response = source.split("&");

        String[] id = response[0].split("=");
        String[] ISBN = response[1].split("=");
        String[] title = response[2].split("=");
        String[] authors = response[3].split(", ");
        String[] categories = response[5].split("=");
        String publisher = response[7];
        String[] yearOfIssue = response[8].split("=");
        String catalogue = response[9];
        String[] bookAmount = response[10].split("=");


        List<AuthorDto> authorsDto = Arrays.stream(authors).map(stringToAuthorDtoConverter::convert).collect(Collectors.toList());
        List<CategoryDto> categoriesDto = Arrays.stream(categories).map(stringToCategoryDtoConverter::convert).collect(Collectors.toList());

        bookDto.setId(Integer.valueOf(id[1]));
        bookDto.setISBN(ISBN[1]);
        bookDto.setTitle(title[1]);
        bookDto.setAuthors(authorsDto);
        bookDto.setCategories(categoriesDto);
        bookDto.setPublisher(stringToPublisherDtoConverter.convert(publisher));
        bookDto.setYearOfIssue(Integer.valueOf(yearOfIssue[1]));
        bookDto.setCatalogue(stringToCatalogueDtoConverter.convert(catalogue));
        bookDto.setBookAmount(Integer.valueOf(bookAmount[1]));

        return bookDto;
    }

}

package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.BookDto;
import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.model.entity.Book;
import com.academy.libray_task.model.entity.Catalogue;
import com.academy.libray_task.model.entity.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookMapperTest {

    private final BookMapper bookMapper = new BookMapperImpl(new AuthorMapperImpl(), new CategoryMapperImpl(), new PublisherMapperImpl(), new CatalogueMapperImpl());
    private Book entity;
    private BookDto dto;

    @BeforeEach
    void init() {
        Catalogue catalogue = Catalogue.builder()
                .name("Catalogue")
                .build();
        CatalogueDto catalogueDto = CatalogueDto.builder()
                .name("CatalogueDto")
                .build();
        Publisher publisher = Publisher.builder()
                .name("Publisher")
                .country("Country")
                .build();
        PublisherDto publisherDto = PublisherDto.builder()
                .name("PublisherDto")
                .country("CountryDto")
                .build();

        entity = Book.builder()
                .ISBN("545-58-00-9")
                .title("TitleTest")
                .publisher(publisher)
                .yearOfIssue(2023)
                .catalogue(catalogue)
                .bookAmount(1)
                .build();

        dto = BookDto.builder()
                .ISBN("545-58-00-9")
                .title("TitleTest")
                .publisher(publisherDto)
                .yearOfIssue(2023)
                .catalogue(catalogueDto)
                .bookAmount(1)
                .build();
    }

    @Test
    void toDto_shouldMapEntityToDto_thenCorrect() {
        BookDto mappedDto = bookMapper.toDto(entity);

        assertEquals(entity.getTitle(), mappedDto.getTitle());
    }

    @Test
    void toDto_shouldMapDtoToEntity_thenCorrect() {
        Book mappedEntity = bookMapper.toEntity(dto);

        assertEquals(dto.getISBN(), mappedEntity.getISBN());
    }

    @Test
    void toDtoList_shouldMapEntityListToDtoList_thenCorrect() {
        List<Book> entityList = Collections.singletonList(entity);

        List<BookDto> dtoList = bookMapper.toDtoList(entityList);

        assertNotNull(dtoList);
        assertEquals(1, dtoList.size());
        assertEquals(entity.getTitle(), dtoList.get(0).getTitle());
        assertEquals(entity.getISBN(), dtoList.get(0).getISBN());
    }

    @Test
    void toDtoList_shouldMapDtoListToEntityList_thenCorrect() {
        List<BookDto> dtoList = Collections.singletonList(dto);

        List<Book> entityList = bookMapper.toEntityList(dtoList);

        assertNotNull(entityList);
        assertEquals(1, entityList.size());
        assertEquals(dto.getISBN(), entityList.get(0).getISBN());
        assertEquals(dto.getBookAmount(), entityList.get(0).getBookAmount());
    }

}

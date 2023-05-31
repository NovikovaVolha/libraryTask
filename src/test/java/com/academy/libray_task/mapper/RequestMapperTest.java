package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.*;
import com.academy.libray_task.dto.enums.RoleDto;
import com.academy.libray_task.mapper.enums.RequestStatusMapperImpl;
import com.academy.libray_task.mapper.enums.RequestTypeMapperImpl;
import com.academy.libray_task.mapper.enums.RoleMapperImpl;
import com.academy.libray_task.model.entity.*;
import com.academy.libray_task.model.entity.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestMapperTest {

    private final RequestMapper requestMapper = new RequestMapperImpl(new UserMapperImpl(new RoleMapperImpl()),
            new BookMapperImpl(new AuthorMapperImpl(), new CategoryMapperImpl(), new PublisherMapperImpl(), new CatalogueMapperImpl()),
            new RequestStatusMapperImpl(),
            new RequestTypeMapperImpl());
    private Request entity;
    private RequestDto dto;

    @BeforeEach
    void init() {
        User librarian = User.builder()
                .name("Librarian")
                .surname("UserSurname")
                .phoneNumber("375291112233")
                .roles(Collections.singletonList(Role.ROLE_LIBRARIAN))
                .build();
        User reader = User.builder()
                .name("Reader")
                .surname("UserSurname")
                .phoneNumber("375291112233")
                .roles(Collections.singletonList(Role.ROLE_READER))
                .build();
        Book book = Book.builder()
                .ISBN("545-58-00-9")
                .title("Book")
                .publisher(Publisher.builder().build())
                .yearOfIssue(2023)
                .catalogue(Catalogue.builder().build())
                .bookAmount(1)
                .build();

        UserDto librarianDto = UserDto.builder()
                .name("LibrarianDto")
                .surname("UserSurname")
                .phoneNumber("375291112233")
                .roles(Collections.singletonList(RoleDto.БИБЛИОТЕКАРЬ))
                .build();
        UserDto readerDto = UserDto.builder()
                .name("ReaderDto")
                .surname("UserSurname")
                .phoneNumber("375291112233")
                .roles(Collections.singletonList(RoleDto.ЧИТАТЕЛЬ))
                .build();
        BookDto bookDto = BookDto.builder()
                .ISBN("545-58-00-9")
                .title("BookDto")
                .publisher(PublisherDto.builder().build())
                .yearOfIssue(2023)
                .catalogue(CatalogueDto.builder().build())
                .bookAmount(1)
                .build();

        entity = Request.builder()
                .librarian(librarian)
                .reader(reader)
                .book(book)
                .build();

        dto = RequestDto.builder()
                .librarian(librarianDto)
                .reader(readerDto)
                .book(bookDto)
                .build();
    }

    @Test
    void toDto_shouldMapEntityToDto_thenCorrect() {
        RequestDto mappedDto = requestMapper.toDto(entity);

        assertEquals(entity.getLibrarian().getName(), mappedDto.getLibrarian().getName());
    }

    @Test
    void toDto_shouldMapDtoToEntity_thenCorrect() {
        Request mappedEntity = requestMapper.toEntity(dto);

        assertEquals(dto.getReader().getName(), mappedEntity.getReader().getName());
    }

}

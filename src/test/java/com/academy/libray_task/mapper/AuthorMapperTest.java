package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.AuthorDto;
import com.academy.libray_task.model.entity.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthorMapperTest {

    private final AuthorMapper authorMapper = new AuthorMapperImpl();
    private Author entity;
    private AuthorDto dto;

    @BeforeEach
    void init() {
        entity = Author.builder()
                .name("TestName")
                .surname("TestSurname")
                .build();

        dto = AuthorDto.builder()
                .name("TestName")
                .surname("TestSurname")
                .build();
    }

    @Test
    void toDto_shouldMapEntityToDto_thenCorrect() {
        AuthorDto mappedDto = authorMapper.toDto(entity);

        assertEquals(entity.getName(), mappedDto.getName());
        assertEquals(entity.getSurname(), mappedDto.getSurname());
    }

    @Test
    void toDto_shouldMapDtoToEntity_thenCorrect() {
        Author mappedEntity = authorMapper.toEntity(dto);

        assertEquals(dto.getName(), mappedEntity.getName());
        assertEquals(dto.getSurname(), mappedEntity.getSurname());
    }

    @Test
    void toDtoList_shouldMapEntityListToDtoList_thenCorrect() {
        List<Author> entityList = Collections.singletonList(entity);

        List<AuthorDto> dtoList = authorMapper.toDtoList(entityList);

        assertNotNull(dtoList);
        assertEquals(1, dtoList.size());
        assertEquals(entity.getName(), dtoList.get(0).getName());
        assertEquals(entity.getSurname(), dtoList.get(0).getSurname());
    }

    @Test
    void toDtoList_shouldMapDtoListToEntityList_thenCorrect() {
        List<AuthorDto> dtoList = Collections.singletonList(dto);

        List<Author> entityList = authorMapper.toEntityList(dtoList);

        assertNotNull(entityList);
        assertEquals(1, entityList.size());
        assertEquals(dto.getName(), entityList.get(0).getName());
        assertEquals(dto.getSurname(), entityList.get(0).getSurname());
    }

}

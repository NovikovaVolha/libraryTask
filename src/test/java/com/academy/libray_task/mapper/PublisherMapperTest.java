package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.model.entity.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublisherMapperTest {

    private final PublisherMapper publisherMapper = new PublisherMapperImpl();
    private Publisher entity;
    private PublisherDto dto;

    @BeforeEach
    void init() {
        entity = Publisher.builder()
                .name("Publisher")
                .country("Country")
                .build();

        dto = PublisherDto.builder()
                .name("PublisherDto")
                .country("Country")
                .build();
    }

    @Test
    void toDto_shouldMapEntityToDto_thenCorrect() {
        PublisherDto mappedDto = publisherMapper.toDto(entity);

        assertEquals(entity.getName(), mappedDto.getName());
        assertEquals(entity.getCountry(), mappedDto.getCountry());
    }

    @Test
    void toDto_shouldMapDtoToEntity_thenCorrect() {
        Publisher mappedEntity = publisherMapper.toEntity(dto);

        assertEquals(dto.getName(), mappedEntity.getName());
        assertEquals(dto.getCountry(), mappedEntity.getCountry());
    }

}

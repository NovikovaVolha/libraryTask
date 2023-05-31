package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.model.entity.Catalogue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogueMapperTest {

    private final CatalogueMapper catalogueMapper = new CatalogueMapperImpl();
    private Catalogue entity;
    private CatalogueDto dto;

    @BeforeEach
    void init() {
        entity = Catalogue.builder()
                .name("Catalogue")
                .build();

        dto = CatalogueDto.builder()
                .name("CatalogueDto")
                .build();
    }

    @Test
    void toDto_shouldMapEntityToDto_thenCorrect() {
        CatalogueDto mappedDto = catalogueMapper.toDto(entity);

        assertEquals(entity.getName(), mappedDto.getName());
    }

    @Test
    void toDto_shouldMapDtoToEntity_thenCorrect() {
        Catalogue mappedEntity = catalogueMapper.toEntity(dto);

        assertEquals(dto.getName(), mappedEntity.getName());
    }

}

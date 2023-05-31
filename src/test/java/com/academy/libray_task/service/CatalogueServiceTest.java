package com.academy.libray_task.service;

import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.mapper.CatalogueMapper;
import com.academy.libray_task.model.entity.Catalogue;
import com.academy.libray_task.model.repository.CatalogueRepository;
import com.academy.libray_task.service.impl.CatalogueServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatalogueServiceTest {

    @InjectMocks
    private CatalogueServiceImpl catalogueService;
    @Mock
    private CatalogueRepository catalogueRepository;
    @Mock
    private CatalogueMapper catalogueMapper;
    private Catalogue catalogue;
    private CatalogueDto catalogueDto;

    @BeforeEach
    void init() {
        catalogue = new Catalogue();
        catalogue.setId(1);
        catalogue.setName("name");

        catalogueDto = new CatalogueDto();
        catalogueDto.setId(1);
        catalogueDto.setName("name");
    }

    @Test
    void findAll_shouldReturnCataloguesList_thenCorrect() {
        List<Catalogue> catalogues = Collections.singletonList(catalogue);
        when(catalogueRepository.findAll()).thenReturn(catalogues);

        List<CatalogueDto> expected = Collections.singletonList(catalogueDto);
        when(catalogueMapper.toDtoList(catalogues)).thenReturn(expected);

        List<CatalogueDto> actual = catalogueService.findAll();
        verify(catalogueRepository).findAll();
        verify(catalogueMapper).toDtoList(catalogues);
        assertEquals(expected, actual);
    }

    @Test
    void findByName_shouldReturnCataloguesList_thenCorrect() {
        List<Catalogue> catalogues = Collections.singletonList(catalogue);
        when(catalogueRepository.findCataloguesByNameContainingIgnoreCase("name")).thenReturn(catalogues);

        List<CatalogueDto> expected = Collections.singletonList(catalogueDto);
        when(catalogueService.findByName("name")).thenReturn(expected);

        List<CatalogueDto> actual = catalogueService.findByName("name");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void delete_shouldDeleteCatalogue_thenCorrect() {
        Integer id = 1;
        catalogueService.delete(id);
        verify(catalogueRepository, times(1)).deleteById(id);
    }

}

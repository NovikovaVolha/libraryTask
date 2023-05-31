package com.academy.libray_task.service;

import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.mapper.PublisherMapper;
import com.academy.libray_task.model.entity.Publisher;
import com.academy.libray_task.model.repository.PublisherRepository;
import com.academy.libray_task.service.impl.PublisherServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceTest {

    @InjectMocks
    private PublisherServiceImpl publisherService;
    @Mock
    private PublisherRepository publisherRepository;
    @Mock
    private PublisherMapper publisherMapper;
    private Publisher publisher;
    private PublisherDto publisherDto;

    @BeforeEach
    void init() {
        publisher = new Publisher();
        publisher.setId(1);
        publisher.setName("name");

        publisherDto = new PublisherDto();
        publisherDto.setId(1);
        publisherDto.setName("name");
    }

    @Test
    void findAll_shouldReturnAuthorsList_thenCorrect() {
        List<Publisher> publishers = Collections.singletonList(publisher);
        when(publisherRepository.findAll()).thenReturn(publishers);

        List<PublisherDto> publishersDto = Collections.singletonList(publisherDto);
        when(publisherMapper.toDtoList(publishers)).thenReturn(publishersDto);

        List<PublisherDto> actual = publisherService.findAll();
        verify(publisherRepository).findAll();
        verify(publisherMapper).toDtoList(publishers);
        assertEquals(publishersDto, actual);
    }

    @Test
    void findByName_shouldReturnAuthorsList_thenCorrect() {
        List<Publisher> publishers = Collections.singletonList(publisher);
        when(publisherRepository.findPublishersByNameContainingIgnoreCase("name")).thenReturn(publishers);

        List<PublisherDto> expected = publisherMapper.toDtoList(publishers);
        when(publisherService.findByName("name")).thenReturn(expected);

        List<PublisherDto> actual = publisherService.findByName("name");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void delete_shouldDeleteAuthor_thenCorrect() {
        Integer id = 1;
        publisherService.delete(id);
        verify(publisherRepository, times(1)).deleteById(id);
    }

}

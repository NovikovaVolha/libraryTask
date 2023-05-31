package com.academy.libray_task.service;

import com.academy.libray_task.dto.BookDto;
import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.dto.RequestDto;
import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.mapper.RequestMapper;
import com.academy.libray_task.model.entity.Book;
import com.academy.libray_task.model.entity.Publisher;
import com.academy.libray_task.model.entity.Request;
import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.repository.RequestRepository;
import com.academy.libray_task.service.impl.RequestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {

    @InjectMocks
    private RequestServiceImpl requestService;
    @Mock
    private RequestRepository requestRepository;
    @Mock
    private RequestMapper requestMapper;
    private Request request;
    private RequestDto requestDto;

    @BeforeEach
    void init() {
        request = new Request();
        request.setId(1);
        request.setLibrarian(new User());
        request.setReader(new User());
        request.setBook(new Book());

        requestDto = new RequestDto();
        requestDto.setId(1);
        requestDto.setLibrarian(new UserDto());
        requestDto.setReader(new UserDto());
        requestDto.setBook(new BookDto());
    }

    @Test
    void findAll_shouldReturnRequestsList_thenCorrect() {
        List<Request> requests = Collections.singletonList(request);
        when(requestRepository.findAll()).thenReturn(requests);

        List<RequestDto> requestsDto = Collections.singletonList(requestDto);
        when(requestMapper.toDtoList(requests)).thenReturn(requestsDto);

        List<RequestDto> actual = requestService.findAll();

        verify(requestRepository).findAll();
        verify(requestMapper).toDtoList(requests);
        assertEquals(requestsDto, actual);
    }

    @Test
    void findById_shouldReturnRequest_thenCorrect(){
        Integer id = 1;
        when(requestRepository.getReferenceById(id)).thenReturn(request);

        RequestDto expected = requestMapper.toDto(request);
        RequestDto actual = requestService.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    void delete_shouldDeleteRequest_thenCorrect() {
        Integer id = 1;
        requestService.delete(id);
        verify(requestRepository, times(1)).deleteById(id);
    }


}

package com.academy.libray_task.controller;

import com.academy.libray_task.dto.AuthorDto;
import com.academy.libray_task.model.entity.Author;
import com.academy.libray_task.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
//public class AuthorControllerTest {
//
//    @InjectMocks
//    private AuthorController authorController;
//    @Mock
//    private AuthorService authorService;
//
//    @Test
//    void getAllAuthors_shouldReturnAuthors_thenCorrect(){
//        AuthorDto authorDto = mock(AuthorDto.class);
//        List<AuthorDto> authorsDto = Collections.singletonList(authorDto);
//        when(authorService.findAll()).thenReturn(authorsDto);
//
//        when(authorController.getAllAuthors()).thenReturn("author/authors");
//
//        verify(authorService).findAll();
//
//    }
//
//
//}

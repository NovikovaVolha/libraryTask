package com.academy.libray_task.service;

import com.academy.libray_task.dto.AuthorDto;
import com.academy.libray_task.mapper.AuthorMapper;
import com.academy.libray_task.model.entity.Author;
import com.academy.libray_task.model.repository.AuthorRepository;
import com.academy.libray_task.service.impl.AuthorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    private AuthorServiceImpl authorService;
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private AuthorMapper authorMapper;
    private AuthorDto authorDto;
    private Author author;

    @BeforeEach
    void init() {
        author = new Author();
        author.setId(1);
        author.setName("name");
        author.setSurname("surname");

        authorDto = new AuthorDto();
        authorDto.setId(1);
        authorDto.setName("name");
        authorDto.setSurname("surname");
    }

    @Test
    void findAll_shouldReturnAuthorsList_thenCorrect() {
        List<Author> authors = Collections.singletonList(author);
        when(authorRepository.findAll()).thenReturn(authors);

        List<AuthorDto> authorsDto = Collections.singletonList(authorDto);
        when(authorMapper.toDtoList(authors)).thenReturn(authorsDto);

        List<AuthorDto> actual = authorService.findAll();
        verify(authorRepository).findAll();
        verify(authorMapper).toDtoList(authors);
        assertEquals(authorsDto, actual);
    }

    @Test
    void findByName_shouldReturnAuthorsList_thenCorrect() {
        List<Author> authors = Collections.singletonList(author);
        when(authorRepository.findAuthorByNameContainingIgnoreCase("name")).thenReturn(authors);

        List<AuthorDto> expected = authorMapper.toDtoList(authors);
        when(authorService.findByName("name")).thenReturn(expected);

        List<AuthorDto> actual = authorService.findByName("name");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void delete_shouldDeleteAuthor_thenCorrect() {
        Integer id = 1;
        authorService.delete(id);
        verify(authorRepository, times(1)).deleteById(id);
    }

}

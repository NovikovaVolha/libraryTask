package com.academy.libray_task.service;

import com.academy.libray_task.converter.book.BookToBookToSaveConverter;
import com.academy.libray_task.converter.book.BookToSaveToBookConverter;
import com.academy.libray_task.dto.BookDto;
import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.mapper.BookMapper;
import com.academy.libray_task.model.entity.Book;
import com.academy.libray_task.model.entity.Catalogue;
import com.academy.libray_task.model.entity.Publisher;
import com.academy.libray_task.model.repository.*;
import com.academy.libray_task.service.impl.BookServiceImpl;
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
public class BookServiceTest {

    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookMapper bookMapper;
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CatalogueRepository catalogueRepository;
    @Mock
    private PublisherRepository publisherRepository;
    @Mock
    private BookToSaveToBookConverter toBookConverter;
    @Mock
    private BookToBookToSaveConverter toBookToSaveConverter;
    private Book book;
    private BookDto bookDto;
    private Publisher publisher;
    private PublisherDto publisherDto;
    private Catalogue catalogue;
    private CatalogueDto catalogueDto;

    @BeforeEach
    void init() {
        publisher = new Publisher();
        publisher.setName("publisher");
        publisher.setCountry("country");

        catalogue = new Catalogue();
        catalogue.setName("catalogue");

        book = new Book();
        book.setId(1);
        book.setISBN("name");
        book.setTitle("title");
        book.setPublisher(publisher);
        book.setCatalogue(catalogue);
        book.setYearOfIssue(2023);
        book.setBookAmount(2);

        publisherDto = new PublisherDto();
        publisherDto.setName("publisher");
        publisherDto.setCountry("country");

        catalogueDto = new CatalogueDto();
        catalogueDto.setName("catalogue");

        bookDto = new BookDto();
        bookDto.setId(1);
        bookDto.setISBN("name");
        bookDto.setTitle("title");
        bookDto.setPublisher(publisherDto);
        bookDto.setCatalogue(catalogueDto);
        bookDto.setYearOfIssue(2023);
        bookDto.setBookAmount(2);
    }

    @Test
    void findAll_shouldReturnBooksList_thenCorrect() {
        List<Book> books = Collections.singletonList(book);
        when(bookRepository.findAll()).thenReturn(books);

        List<BookDto> booksDto = Collections.singletonList(bookDto);
        when(bookMapper.toDtoList(books)).thenReturn(booksDto);

        List<BookDto> actual = bookService.findAll();
        verify(bookRepository).findAll();
        verify(bookMapper).toDtoList(books);
        assertEquals(booksDto, actual);
    }

    //@Test
    void findByCatalogue_shouldReturnBookList_thenCorrect(){
        List<Book> books = Collections.singletonList(book);
        when(bookRepository.findBooksByCatalogue(catalogue)).thenReturn(books);

        List<BookDto> expected = bookMapper.toDtoList(books);
        when(bookService.findByCatalogue(catalogueDto.getName())).thenReturn(expected);

        List<BookDto> actual = bookService.findByCatalogue(catalogueDto.getName());

        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    void findByBookAmount_shouldReturnBooksList_thenCorrect(){
        List<Book> books = Collections.singletonList(book);
        when(bookRepository.findBooksByBookAmount(book.getBookAmount())).thenReturn(books);

        List<BookDto> expected = bookMapper.toDtoList(books);
        when(bookService.findByBookAmount(bookDto.getBookAmount())).thenReturn(expected);

        List<BookDto> actual = bookService.findByBookAmount(bookDto.getBookAmount());
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void findByTitle_shouldReturnBooksList_thenCorrect(){
        List<Book> books = Collections.singletonList(book);
        when(bookRepository.findBookByTitleContainingIgnoreCase(book.getTitle())).thenReturn(books);

        List<BookDto> expected = bookMapper.toDtoList(books);
        when(bookService.findByTitle(bookDto.getTitle())).thenReturn(expected);

        List<BookDto> actual = bookService.findByTitle(bookDto.getTitle());
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void delete_shouldDeleteBook_thenCorrect() {
        Integer id = 1;
        bookService.delete(id);
        verify(bookRepository, times(1)).deleteById(id);
    }


}

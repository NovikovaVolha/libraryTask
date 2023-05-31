package com.academy.libray_task.service;

import com.academy.libray_task.dto.*;
import com.academy.libray_task.model.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    void save(BookToSave bookToSave);

    List<BookDto> findAll();

    Page<BookDto> findAllPaginated(Integer pageNumber, Integer pageSize);

    BookDto findById(Integer id);

    BookToSave findForUpdate(Integer id);

    List<BookDto> findByISBN(String ISBN);

    List<BookDto> findByTitle(String title);

    List<BookDto> findByAuthor(String authorName);

    List<BookDto> findByCategory(String categoryName);

    List<BookDto> findByPublisher(String publisherName);

    List<BookDto> findBooksByYearOfIssue(Integer yearOfIssue);

    List<BookDto> findByCatalogue(String catalogueName);

    List<BookDto> findByBookAmount(Integer bookAmount);

    void delete(Integer id);

}

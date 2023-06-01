package com.academy.libray_task.service.impl;

import com.academy.libray_task.converter.book.BookToBookToSaveConverter;
import com.academy.libray_task.converter.book.BookToSaveToBookConverter;
import com.academy.libray_task.dto.*;
import com.academy.libray_task.mapper.*;
import com.academy.libray_task.model.entity.*;
import com.academy.libray_task.model.entity.Author;
import com.academy.libray_task.model.repository.*;
import com.academy.libray_task.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final CatalogueRepository catalogueRepository;
    private final PublisherRepository publisherRepository;
    private final BookToSaveToBookConverter toBookConverter;
    private final BookToBookToSaveConverter toBookToSaveConverter;

    @Override
    public void save(BookToSave bookToSave) {
        Book book = toBookConverter.convert(bookToSave);
        assert book != null;
        bookRepository.save(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    public Page<BookDto> findAllPaginated(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        Page<Book> pages = bookRepository.findAll(pageable);
        return pages.map(bookMapper::toDto);
    }

    @Override
    public BookDto findById(Integer id) {
        return bookMapper.toDto(bookRepository.getReferenceById(id));
    }

    @Override
    public BookToSave findForUpdate(Integer id) {
        Book book = bookRepository.getReferenceById(id);
        return toBookToSaveConverter.convert(book);
    }

    @Override
    public List<BookDto> findByISBN(String ISBN) {
        return bookMapper.toDtoList(bookRepository.findBookByISBN(ISBN));
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        return bookMapper.toDtoList(bookRepository.findBookByTitleContainingIgnoreCase(title));
    }

    @Override
    public List<BookDto> findByAuthor(String author) {
        List<Author> authors = new ArrayList<>();
        if (author.contains(" ")) {
            String[] parts = author.split(" ");
            authors.add(authorRepository.findAuthorByNameAndSurname(parts[0], parts[1]));
        } else {
            authors.addAll(authorRepository.findAuthorBySurnameContainingIgnoreCase(author));
        }
        return bookMapper.toDtoList(bookRepository.findBooksByAuthorsIn(authors));
    }

    @Override
    public List<BookDto> findByCategory(String categoryName) {
        List<Category> categories = categoryRepository.findCategoryByNameContainingIgnoreCase(categoryName);
        return bookMapper.toDtoList(bookRepository.findBooksByCategoriesIn(categories));
    }

    @Override
    public List<BookDto> findByPublisher(String publisherName) {
        List<Publisher> publishers = publisherRepository.findPublishersByNameContainingIgnoreCase(publisherName);
        return bookMapper.toDtoList(bookRepository.findBooksByPublisher(publishers.get(0)));
    }

    @Override
    public List<BookDto> findBooksByYearOfIssue(Integer yearOfIssue) {
        return bookMapper.toDtoList(bookRepository.findBooksByYearOfIssue(yearOfIssue));
    }

    @Override
    public List<BookDto> findByCatalogue(String catalogueName) {
        List<Catalogue> catalogues = catalogueRepository.findCataloguesByNameContainingIgnoreCase(catalogueName);
        return bookMapper.toDtoList(bookRepository.findBooksByCatalogue(catalogues.get(0)));
    }

    @Override
    public List<BookDto> findByBookAmount(Integer bookAmount) {
        return bookMapper.toDtoList(bookRepository.findBooksByBookAmount(bookAmount));
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

}

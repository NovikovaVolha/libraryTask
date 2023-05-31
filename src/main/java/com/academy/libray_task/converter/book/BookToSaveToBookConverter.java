package com.academy.libray_task.converter.book;

import com.academy.libray_task.dto.BookToSave;
import com.academy.libray_task.model.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookToSaveToBookConverter implements Converter<BookToSave, Book> {

    private final StringToAuthorConverter authorConverter;
    private final StringToCategoryConverter categoryConverter;
    private final StringToCatalogueConverter catalogueConverter;
    private final StringToPublisherConverter publisherConverter;

    @Override
    public Book convert(BookToSave bookToSave) {
        Book book = new Book();

        book.setId(bookToSave.getId());
        book.setISBN(bookToSave.getISBN());
        book.setTitle(bookToSave.getTitle());
        book.setCatalogue(catalogueConverter.convert(bookToSave.getCatalogue()));
        book.setPublisher(publisherConverter.convert(bookToSave.getPublisher()));
        book.setYearOfIssue(Integer.valueOf(bookToSave.getYearOfIssue()));
        book.setBookAmount(Integer.valueOf(bookToSave.getBookAmount()));
        book.setAuthors(authorConverter.convert(bookToSave.getAuthors()));
        book.setCategories(categoryConverter.convert(bookToSave.getCategories()));

        return book;
    }

}

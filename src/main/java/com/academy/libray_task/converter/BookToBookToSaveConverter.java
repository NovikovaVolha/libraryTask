package com.academy.libray_task.converter;

import com.academy.libray_task.dto.BookToSave;
import com.academy.libray_task.model.entity.Author;
import com.academy.libray_task.model.entity.Book;
import com.academy.libray_task.model.entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookToSaveConverter implements Converter<Book, BookToSave> {
    @Override
    public BookToSave convert(Book book) {
        BookToSave bookToSave = new BookToSave();

        StringBuilder authors = new StringBuilder();
        for (Author author : book.getAuthors()) {
            authors.append(author.toString());
        }

        StringBuilder categories = new StringBuilder();
        for (Category category : book.getCategories()) {
            categories.append(category.toString());
        }

        bookToSave.setId(book.getId());
        bookToSave.setISBN(book.getISBN());
        bookToSave.setTitle(book.getTitle());
        bookToSave.setAuthors(authors.toString());
        bookToSave.setCategories(categories.toString());
        bookToSave.setCatalogue(book.getCatalogue().toString());
        bookToSave.setPublisher(book.getPublisher().toString());
        bookToSave.setYearOfIssue(String.valueOf(book.getYearOfIssue()));
        bookToSave.setBookAmount(String.valueOf(book.getBookAmount()));

        return bookToSave;
    }

}

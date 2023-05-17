package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.Book;
import com.academy.libray_task.model.entity.Catalogue;
import com.academy.libray_task.model.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookByISBN(String ISBN);

    List<Book> findBookByTitleContainingIgnoreCase(String title);

//    List<Book> findBooksByAuthors(List<Author> authors);
//
//    List<Book> findBooksByCategories(List<Category> categories);

    List<Book> findBooksByPublisher(Publisher publisher);

    List<Book> findBooksByYearOfIssue(Integer yearOfIssue);

    List<Book> findBooksByCatalogue(Catalogue catalogue);

    List<Book> findBooksByBookAmount(Integer bookAmount);

}

package com.academy.libray_task.service;

import com.academy.libray_task.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchUtilService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final PublisherService publisherService;
    private final RequestService requestService;
    private final UserService userService;

    public List<RequestDto> findRequestsByParamName(String paramName, String paramValue) {
        return switch (paramName) {
            case "reader" -> requestService.findByReader(paramValue);
            case "librarian" -> requestService.findByLibrarian(paramValue);
            case "book" -> requestService.findByBook(paramValue);
            case "dateOfIssue" ->
                    requestService.findByDateOfIssue(LocalDate.parse(paramValue, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            case "dateOfReturn" ->
                    requestService.findByDateOfReturn(LocalDate.parse(paramValue, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            case "requestStatus" -> requestService.findByRequestStatus(paramValue);
            case "requestType" -> requestService.findByRequestType(paramValue);
            default -> throw new IllegalStateException("Параметр поиска " + paramValue + " не найден.");
        };
    }

    public List<UserDto> findUsersByParamName(String paramName, String paramValue) {
        return switch (paramName) {
            case "name" -> userService.findByName(paramValue);
            case "surname" -> userService.findBySurname(paramValue);
            case "passport" -> userService.findByPassport(paramValue);
            case "phoneNumber" -> userService.findByPhoneNumber(String.valueOf(paramValue));
            case "roles" -> userService.findByRole(paramValue);
            default -> throw new IllegalStateException("Параметр поиска " + paramValue + " не найден.");
        };
    }

    public List<BookDto> findBooksByParamName(String paramName, String paramValue) {
        return switch (paramName) {
            case "title" -> bookService.findByTitle(paramValue);
            case "ISBN" -> bookService.findByISBN(String.valueOf(paramValue));
            case "authorName" -> bookService.findByAuthor(paramValue);
            case "categoryName" -> bookService.findByCategory(paramValue);
            case "publisherName" -> bookService.findByPublisher(paramValue);
            case "yearOfIssue" -> bookService.findBooksByYearOfIssue(Integer.valueOf(paramValue));
            case "catalogueName" -> bookService.findByCatalogue(paramValue);
            case "bookAmount" -> bookService.findByBookAmount(Integer.valueOf(paramValue));
            default -> throw new IllegalStateException("Параметр поиска " + paramValue + " не найден.");
        };
    }

    public List<AuthorDto> findAuthorsByParamName(String paramName, String paramValue) {
        return switch (paramName) {
            case "name" -> authorService.findByName(paramValue);
            case "surname" -> authorService.findBySurname(paramValue);
            default -> throw new IllegalStateException("Параметр поиска " + paramValue + " не найден.");
        };
    }

    public List<PublisherDto> findPublishersByParamName(String paramName, String paramValue) {
        return switch (paramName) {
            case "name" -> publisherService.findByName(paramValue);
            case "country" -> publisherService.findByCountry(paramValue);
            default -> throw new IllegalStateException("Параметр поиска " + paramValue + " не найден.");
        };
    }

}

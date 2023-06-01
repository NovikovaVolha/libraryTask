package com.academy.libray_task.converter.request;

import com.academy.libray_task.converter.book.BookToBookToSaveConverter;
import com.academy.libray_task.converter.book.BookToSaveToBookConverter;
import com.academy.libray_task.dto.RequestToSave;
import com.academy.libray_task.dto.enums.RequestStatusDto;
import com.academy.libray_task.dto.enums.RequestTypeDto;
import com.academy.libray_task.mapper.enums.RequestStatusMapper;
import com.academy.libray_task.mapper.enums.RequestTypeMapper;
import com.academy.libray_task.model.entity.Book;
import com.academy.libray_task.model.entity.Request;
import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.entity.enums.RequestStatus;
import com.academy.libray_task.model.entity.enums.RequestType;
import com.academy.libray_task.model.repository.BookRepository;
import com.academy.libray_task.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class RequestToSaveToRequestConverter implements Converter<RequestToSave, Request> {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final RequestTypeMapper requestTypeMapper;
    private final RequestStatusMapper requestStatusMapper;
    private final BookToSaveToBookConverter toBookConverter;

    @Override
    public Request convert(RequestToSave requestToSave) {
        Request request = new Request();

        String[] librarianNameAndSurname = requestToSave.getLibrarian().split(" ");
        User librarian = userRepository.findUserByNameAndSurname(librarianNameAndSurname[0], librarianNameAndSurname[1]);

        String[] readerNameAndSurname = requestToSave.getReader().split(" ");
        User reader = userRepository.findUserByNameAndSurname(readerNameAndSurname[0], readerNameAndSurname[1]);

        String[] titleAndAuthors = requestToSave.getBook().split(" \\[");
        String title = titleAndAuthors[0];
        Book book = bookRepository.findBookByTitle(title);

        RequestStatus requestStatus = requestStatusMapper.toEntity(RequestStatusDto.valueOf(requestToSave.getRequestStatus()));
        RequestType requestType = requestTypeMapper.toEntity(RequestTypeDto.valueOf(requestToSave.getRequestType()));

        request.setId(requestToSave.getId());
        request.setLibrarian(librarian);
        request.setReader(reader);
        request.setBook(book);
        request.setDateOfIssue(LocalDate.parse(requestToSave.getDateOfIssue(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        request.setDateOfReturn(LocalDate.parse(requestToSave.getDateOfReturn(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        request.setRequestStatus(requestStatus);
        request.setRequestType(requestType);

        return request;
    }

}

package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.Book;
import com.academy.libray_task.model.entity.Request;
import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.entity.enums.RequestStatus;
import com.academy.libray_task.model.entity.enums.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findRequestsByLibrarian(User librarian);

    List<Request> findRequestsByReader(User reader);

    List<Request> findRequestsByBook(Book book);

    List<Request> findRequestsByDateOfIssue(LocalDate dateOfIssue);

    List<Request> findRequestsByDateOfReturn(LocalDate dateOfReturn);

    List<Request> findRequestsByRequestStatus(RequestStatus requestStatus);

    List<Request> findRequestsByRequestType(RequestType requestType);

}

package com.academy.libray_task.service;

import com.academy.libray_task.dto.RequestDto;
import com.academy.libray_task.dto.enums.RequestStatusDto;
import com.academy.libray_task.dto.enums.RequestTypeDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface RequestService {

    void save(RequestDto request);

    List<RequestDto> findAll();

    Page<RequestDto> findAllPaginated(Integer pageNumber, Integer pageSize);

    RequestDto findById(Integer id);

    List<RequestDto> findByReader(String readerSurname);

    List<RequestDto> findByLibrarian(String librarianSurname);

    List<RequestDto> findByDateOfIssue(LocalDate dateOfIssue);

    List<RequestDto> findByDateOfReturn(LocalDate dateOfReturn);

    List<RequestDto> findByRequestStatus(RequestStatusDto requestStatus);

    List<RequestDto> findByRequestType(RequestTypeDto requestType);

    void delete(Integer id);

}

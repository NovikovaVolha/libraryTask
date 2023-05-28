package com.academy.libray_task.dto;

import com.academy.libray_task.dto.enums.RequestStatusDto;
import com.academy.libray_task.dto.enums.RequestTypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

    private Integer id;
    private UserDto librarian;
    private UserDto reader;
    private BookDto book;
    private LocalDate dateOfIssue;
    private LocalDate dateOfReturn;
    private RequestStatusDto requestStatus;
    private RequestTypeDto requestType;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}

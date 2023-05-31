package com.academy.libray_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestToSave {

    private Integer id;
    @NotBlank
    private String librarian;
    @NotBlank
    private String reader;
    @NotBlank
    private String book;
    private String dateOfIssue;
    private String dateOfReturn;
    private String requestStatus;
    private String requestType;

    @Override
    public String toString() {
        return reader + " " + requestStatus;
    }

}

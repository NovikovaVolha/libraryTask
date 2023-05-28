package com.academy.libray_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private Integer id;
    private String name;
    private String surname;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @Override
    public String toString() {
        return name + " " + surname;
    }

}

package com.academy.libray_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookToSave {

    private Integer id;
    private String ISBN;
    private String title;
    private String authors;
    private String categories;
    private String publisher;
    private String yearOfIssue;
    private String catalogue;
    private String bookAmount;

    @Override
    public String toString() {
        return title + " " + authors;
    }

}

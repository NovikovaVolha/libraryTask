package com.academy.libray_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;
    private String ISBN;
    private String title;
    private List<AuthorDto> authors;
    private List<CategoryDto> categories;
    private PublisherDto publisher;
    private Integer yearOfIssue;
    private CatalogueDto catalogue;
    private Integer bookAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return title + " " + authors;
    }

}

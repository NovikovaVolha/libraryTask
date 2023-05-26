package com.academy.libray_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogueDto {

    private Integer id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return name;
    }

}

package com.academy.libray_task.dto;

import com.academy.libray_task.dto.enums.RoleDto;
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
public class UserDto {

    private Integer id;
    private String name;
    private String surname;
    private String passport;
    private String phoneNumber;
    private RoleDto role;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
    @Override
    public String toString() {
        return name + " " + surname;
    }

}

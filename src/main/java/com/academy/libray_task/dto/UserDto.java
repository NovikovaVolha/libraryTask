package com.academy.libray_task.dto;

import com.academy.libray_task.dto.enums.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    @Override
    public String toString() {
        return name + " " + surname;
    }

}

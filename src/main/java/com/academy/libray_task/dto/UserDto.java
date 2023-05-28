package com.academy.libray_task.dto;

import com.academy.libray_task.dto.enums.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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
    private List<RoleDto> roles;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @Override
    public String toString() {
        return name + " " + surname;
    }

}

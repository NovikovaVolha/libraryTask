package com.academy.libray_task.dto;

import com.academy.libray_task.dto.enums.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    private String passport;
    private String phoneNumber;
    private List<RoleDto> roles;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @Override
    public String toString() {
        return name + " " + surname;
    }

}

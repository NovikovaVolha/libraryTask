package com.academy.libray_task.mapper.enums;

import com.academy.libray_task.dto.enums.RoleDto;
import com.academy.libray_task.model.entity.enums.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);

}

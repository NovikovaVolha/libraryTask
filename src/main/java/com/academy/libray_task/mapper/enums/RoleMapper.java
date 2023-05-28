package com.academy.libray_task.mapper.enums;

import com.academy.libray_task.dto.enums.RoleDto;
import com.academy.libray_task.model.entity.enums.Role;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @ValueMappings({@ValueMapping(source = "ROLE_READER", target = "ЧИТАТЕЛЬ"), @ValueMapping(source = "ROLE_LIBRARIAN", target = "БИБЛИОТЕКАРЬ")})
    List<RoleDto> toDtoList(List<Role> roles);

    @ValueMappings({@ValueMapping(source = "ЧИТАТЕЛЬ", target = "ROLE_READER"), @ValueMapping(source = "БИБЛИОТЕКАРЬ", target = "ROLE_LIBRARIAN")})
    List<Role> toEntityList(List<RoleDto> roles);

}

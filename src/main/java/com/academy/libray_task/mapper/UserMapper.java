package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.mapper.enums.RoleMapper;
import com.academy.libray_task.model.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);

    List<User> toEntityList(List<UserDto> usersDto);

}

package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.dto.enums.RoleDto;
import com.academy.libray_task.mapper.enums.RoleMapperImpl;
import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.entity.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {

    private final UserMapper userMapper = new UserMapperImpl(new RoleMapperImpl());
    private User entity;
    private UserDto dto;

    @BeforeEach
    void init() {
        entity = User.builder()
                .name("UserName")
                .surname("UserSurname")
                .phoneNumber("375291112233")
                .roles(Collections.singletonList(Role.ROLE_READER))
                .build();

        dto = UserDto.builder()
                .name("UserDtoName")
                .surname("UserSurname")
                .phoneNumber("375291112233")
                .roles(Collections.singletonList(RoleDto.ЧИТАТЕЛЬ))
                .build();
    }

    @Test
    void toDto_shouldMapEntityToDto_thenCorrect() {
        UserDto mappedDto = userMapper.toDto(entity);

        assertEquals(entity.getName(), mappedDto.getName());
        assertEquals(entity.getSurname(), mappedDto.getSurname());
        assertEquals(entity.getPhoneNumber(), mappedDto.getPhoneNumber());
        assertEquals(entity.getRoles().size(), mappedDto.getRoles().size());
    }

    @Test
    void toDto_shouldMapDtoToEntity_thenCorrect() {
        User mappedEntity = userMapper.toEntity(dto);

        assertEquals(dto.getName(), mappedEntity.getName());
        assertEquals(dto.getSurname(), mappedEntity.getSurname());
        assertEquals(dto.getPhoneNumber(), mappedEntity.getPhoneNumber());
        assertEquals(dto.getRoles().size(), mappedEntity.getRoles().size());
    }

}

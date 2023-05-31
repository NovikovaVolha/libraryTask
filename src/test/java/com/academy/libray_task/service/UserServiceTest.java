package com.academy.libray_task.service;

import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.dto.enums.RoleDto;
import com.academy.libray_task.mapper.UserMapper;
import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.entity.enums.Role;
import com.academy.libray_task.model.repository.UserRepository;
import com.academy.libray_task.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    private User user;
    private UserDto userDto;

    @BeforeEach
    void init() {
        user = new User();
        user.setId(1);
        user.setName("name");
        user.setSurname("surname");
        user.setRoles(Collections.singletonList(Role.ROLE_READER));

        userDto = new UserDto();
        userDto.setId(1);
        userDto.setName("name");
        userDto.setSurname("surname");
        userDto.setRoles(Collections.singletonList(RoleDto.ЧИТАТЕЛЬ));
    }

    @Test
    void findAll_shouldReturnUsersList_thenCorrect() {
        List<User> users = Collections.singletonList(user);
        when(userRepository.findAll()).thenReturn(users);

        List<UserDto> usersDto = Collections.singletonList(userDto);
        when(userMapper.toDtoList(users)).thenReturn(usersDto);

        List<UserDto> actual = userService.findAll();
        verify(userRepository).findAll();
        verify(userMapper).toDtoList(users);
        assertEquals(usersDto, actual);
    }

    @Test
    void findByRole_shouldReturnUsers_thenCorrect() {
        List<User> users = Collections.singletonList(user);
        when(userRepository.findUsersByRolesIn(user.getRoles())).thenReturn(users);

        List<UserDto> expected = Collections.singletonList(userDto);
        when(userService.findByRole("ЧИТАТЕЛЬ")).thenReturn(expected);

        List<UserDto> actual = userService.findByRole("ЧИТАТЕЛЬ");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void findByName_shouldReturnUsersList_thenCorrect() {
        List<User> users = Collections.singletonList(user);
        when(userRepository.findUsersByNameContainingIgnoreCase("name")).thenReturn(users);

        List<UserDto> expected = userMapper.toDtoList(users);
        when(userService.findByName("name")).thenReturn(expected);

        List<UserDto> actual = userService.findByName("name");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void delete_shouldDeleteUser_thenCorrect() {
        Integer id = 1;
        userService.delete(id);
        verify(userRepository).deleteById(id);
    }

}

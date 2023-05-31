package com.academy.libray_task.service;

import com.academy.libray_task.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void save(UserDto user);

    List<UserDto> findAll();

    Page<UserDto> findAllPaginated(Integer pageNumber, Integer pageSize);

    UserDto findById(Integer id);

    List<UserDto> findByName(String name);

    List<UserDto> findBySurname(String surname);

    List<UserDto> findByPassport(String passport);

    List<UserDto> findByPhoneNumber(String phoneNumber);

    List<UserDto> findByRole(String role);

    void delete(Integer id);

    void registerNewUser(UserDto userDto);

    UserDto findByUsername(String username);

}

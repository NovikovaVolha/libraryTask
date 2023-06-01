package com.academy.libray_task.service.impl;

import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.mapper.UserMapper;
import com.academy.libray_task.mapper.enums.RoleMapper;
import com.academy.libray_task.model.entity.Request;
import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.entity.enums.RequestType;
import com.academy.libray_task.model.entity.enums.Role;
import com.academy.libray_task.model.repository.UserRepository;
import com.academy.libray_task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void save(UserDto user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public Page<UserDto> findAllPaginated(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toDto);
    }

    @Override
    public UserDto findById(Integer id) {
        return userMapper.toDto(userRepository.getReferenceById(id));
    }

    @Override
    public List<UserDto> findByName(String name) {
        return userMapper.toDtoList(userRepository.findUsersByNameContainingIgnoreCase(name));
    }

    @Override
    public List<UserDto> findBySurname(String surname) {
        return userMapper.toDtoList(userRepository.findUsersBySurnameContainingIgnoreCase(surname));
    }

    @Override
    public UserDto findByNameAndSurname(String name, String surname) {
        return userMapper.toDto(userRepository.findUserByNameAndSurname(name, surname));
    }

    @Override
    public List<UserDto> findByPassport(String passport) {
        return userMapper.toDtoList(userRepository.findUserByPassport(passport));
    }

    @Override
    public List<UserDto> findByPhoneNumber(String phoneNumber) {
        return userMapper.toDtoList(userRepository.findUsersByPhoneNumberContaining(phoneNumber));
    }

    @Override
    public List<UserDto> findByRole(String role) {
        List<User> users = switch (role.toUpperCase()) {
            case "ЧИТАТЕЛЬ" -> userRepository.findUsersByRolesIn(Collections.singletonList(Role.ROLE_READER));
            case "БИБЛИОТЕКАРЬ" -> userRepository.findUsersByRolesIn(Collections.singletonList(Role.ROLE_LIBRARIAN));
            default -> throw new IllegalArgumentException("Статуса пользователя " + role + " не существует!");
        };
        return userMapper.toDtoList(users);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void registerNewUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassport(userDto.getPassport());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setRoles(roleMapper.toEntityList(userDto.getRoles()));
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public UserDto findByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username));
    }
}

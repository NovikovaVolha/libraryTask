package com.academy.libray_task.service.impl;

import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.mapper.UserMapper;
import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.repository.UserRepository;
import com.academy.libray_task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
    public UserDto findByPassport(String passport) {
        return userMapper.toDto(userRepository.findUserByPassport(passport));
    }

    @Override
    public List<UserDto> findByPhoneNumber(String phoneNumber) {
        return userMapper.toDtoList(userRepository.findUsersByPhoneNumberContaining(phoneNumber));
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}

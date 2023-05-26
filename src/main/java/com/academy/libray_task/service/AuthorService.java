package com.academy.libray_task.service;

import com.academy.libray_task.dto.AuthorDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {

    void save(AuthorDto author);

    List<AuthorDto> findAll();

    Page<AuthorDto> findAllPaginated(Integer pageNumber, Integer pageSize);

    AuthorDto findById(Integer id);

    List<AuthorDto> findByName(String name);

    List<AuthorDto> findBySurname(String surname);

    void delete(Integer id);

}

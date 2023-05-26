package com.academy.libray_task.service.impl;

import com.academy.libray_task.dto.AuthorDto;
import com.academy.libray_task.mapper.AuthorMapper;
import com.academy.libray_task.model.entity.Author;
import com.academy.libray_task.model.repository.AuthorRepository;
import com.academy.libray_task.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public void save(AuthorDto author) {
        authorRepository.save(authorMapper.toEntity(author));
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorMapper.toDtoList(authorRepository.findAll());
    }

    @Override
    public Page<AuthorDto> findAllPaginated(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        Page<Author> authors = authorRepository.findAll(pageable);
        return authors.map(authorMapper::toDto);
    }

    @Override
    public AuthorDto findById(Integer id) {
        return authorMapper.toDto(authorRepository.getReferenceById(id));
    }

    @Override
    public List<AuthorDto> findByName(String name) {
        return authorMapper.toDtoList(authorRepository.findAuthorByNameContainingIgnoreCase(name));
    }

    @Override
    public List<AuthorDto> findBySurname(String surname) {
        return authorMapper.toDtoList(authorRepository.findAuthorBySurnameContainingIgnoreCase(surname));
    }

    @Override
    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }

}

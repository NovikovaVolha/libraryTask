package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAuthorByNameContainingIgnoreCase(String name);

    List<Author> findAuthorBySurnameContainingIgnoreCase(String surname);

    Author findAuthorByNameAndSurname(String name, String surname);

}


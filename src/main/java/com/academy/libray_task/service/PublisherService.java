package com.academy.libray_task.service;

import com.academy.libray_task.dto.PublisherDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PublisherService {

    void save(PublisherDto publisher);

    List<PublisherDto> findAll();

    Page<PublisherDto> findAllPaginated(Integer pageNumber, Integer pageSize);

    PublisherDto findById(Integer id);

    List<PublisherDto> findByName(String name);

    List<PublisherDto> findByCountry(String country);

    void delete(Integer id);

}

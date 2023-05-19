package com.academy.libray_task.service;

import com.academy.libray_task.dto.CatalogueDto;

import java.util.List;

public interface CatalogueService {

    void save(CatalogueDto catalogue);

    List<CatalogueDto> findAll();

    List<CatalogueDto> findAllPaginated(Integer pageNumber, Integer pageSize);

    CatalogueDto findById(Integer id);

    List<CatalogueDto> findByName(String name);

    void delete(Integer id);

}
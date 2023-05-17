package com.academy.libray_task.service;

import com.academy.libray_task.dto.CatalogueDto;

import java.util.List;

public interface CatalogueService {

    void save(CatalogueDto catalogue);

    List<CatalogueDto> findAll();

    CatalogueDto findById(Integer id);

    CatalogueDto findByName(String name);

    void delete(Integer id);

}
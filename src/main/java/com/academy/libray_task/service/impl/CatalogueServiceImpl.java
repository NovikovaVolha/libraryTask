package com.academy.libray_task.service.impl;

import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.mapper.CatalogueMapper;
import com.academy.libray_task.model.repository.CatalogueRepository;
import com.academy.libray_task.service.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogueServiceImpl implements CatalogueService {

    private final CatalogueRepository catalogueRepository;
    private final CatalogueMapper catalogueMapper;

    @Override
    public void save(CatalogueDto catalogue) {
        catalogueRepository.save(catalogueMapper.toEntity(catalogue));
    }

    @Override
    public List<CatalogueDto> findAll() {
        return catalogueMapper.toDtoList(catalogueRepository.findAll());
    }

    @Override
    public CatalogueDto findById(Integer id) {
//        Optional<Course> optionalCourse = courseRepository.findById(id);
//        Course course = null;
//        if (optionalCourse.isPresent()) {
//            course = optionalCourse.get();
//        } else {
//            throw new RuntimeException("Course not found for id : " + id);
//        }
//        return course;
        return catalogueMapper.toDto(catalogueRepository.getReferenceById(id));
    }

    @Override
    public CatalogueDto findByName(String name) {
        return catalogueMapper.toDto(catalogueRepository.findCatalogueByNameContainingIgnoreCase(name));
    }

    @Override
    public void delete(Integer id) {
        catalogueRepository.deleteById(id);
    }
}

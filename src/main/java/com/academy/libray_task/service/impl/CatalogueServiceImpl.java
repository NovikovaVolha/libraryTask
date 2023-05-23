package com.academy.libray_task.service.impl;

import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.mapper.CatalogueMapper;
import com.academy.libray_task.model.entity.Catalogue;
import com.academy.libray_task.model.repository.CatalogueRepository;
import com.academy.libray_task.service.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<CatalogueDto> findAllPaginated(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        Page<Catalogue> catalogues = catalogueRepository.findAll(pageable);
        return catalogues.map(catalogueMapper::toDto);
    }

    @Override
    public CatalogueDto findById(Integer id) {
        return catalogueMapper.toDto(catalogueRepository.getReferenceById(id));
    }

    @Override
    public List<CatalogueDto> findByName(String name) {
        return catalogueMapper.toDtoList(catalogueRepository.findCataloguesByNameContainingIgnoreCase(name));
    }

    @Override
    public void delete(Integer id) {
        catalogueRepository.deleteById(id);
    }

}

package com.academy.libray_task.service.impl;

import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.mapper.PublisherMapper;
import com.academy.libray_task.model.entity.Publisher;
import com.academy.libray_task.model.repository.PublisherRepository;
import com.academy.libray_task.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public void save(PublisherDto publisher) {
        publisherRepository.save(publisherMapper.toEntity(publisher));
    }

    @Override
    public List<PublisherDto> findAll() {
        return publisherMapper.toDtoList(publisherRepository.findAll());
    }

    @Override
    public Page<PublisherDto> findAllPaginated(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        Page<Publisher> publishers = publisherRepository.findAll(pageable);
        return publishers.map(publisherMapper::toDto);
    }

    @Override
    public PublisherDto findById(Integer id) {
        return publisherMapper.toDto(publisherRepository.getReferenceById(id));
    }

    @Override
    public List<PublisherDto> findByName(String name) {
        return publisherMapper.toDtoList(publisherRepository.findPublishersByNameContainingIgnoreCase(name));
    }

    @Override
    public List<PublisherDto> findByCountry(String country) {
        return publisherMapper.toDtoList(publisherRepository.findPublishersByCountryContainingIgnoreCase(country));
    }

    @Override
    public void delete(Integer id) {
        publisherRepository.deleteById(id);
    }

}

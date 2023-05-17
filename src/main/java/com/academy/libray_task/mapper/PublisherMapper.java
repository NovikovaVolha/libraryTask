package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.model.entity.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDto toDto(Publisher publisher);

    Publisher toEntity(PublisherDto publisherDto);

    List<PublisherDto> toDtoList(List<Publisher> publishers);

    List<Publisher> toEntityList(List<PublisherDto> publishersDto);

}

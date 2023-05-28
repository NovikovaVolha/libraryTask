package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.model.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDto toDto(Publisher publisher);

    Publisher toEntity(PublisherDto publisherDto);

    List<PublisherDto> toDtoList(List<Publisher> publishers);

    List<Publisher> toEntityList(List<PublisherDto> publishersDto);


//    @Named("publisherToString")
//    default String toStringFromEntity(PublisherDto publisherDto) {
//        return publisherDto.getName() + " " + publisherDto.getCountry();
//    }
//
//    @Named("stringPublisher")
//    default PublisherDto toEntityFromString(String publisher) {
//        String[] parts = publisher.split(" ");
//        return PublisherDto.builder()
//                .name(parts[0])
//                .country(parts[1])
//                .build();
//    }
////    String toStringFromDto(PublisherDto publisherDto);
////    PublisherDto toDtoFromString(String publisher);

}

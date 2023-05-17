package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.AuthorDto;
import com.academy.libray_task.model.entity.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface AuthorMapper {

    AuthorDto toDto(Author author);

    Author toEntity(AuthorDto authorDto);

    List<AuthorDto> toDtoList(List<Author> authors);

    List<Author> toEntityList(List<AuthorDto> authorsDto);

}

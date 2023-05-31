package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.*;
import com.academy.libray_task.model.entity.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class, CategoryMapper.class, PublisherMapper.class, CatalogueMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);

    List<BookDto> toDtoList(List<Book> books);

    List<Book> toEntityList(List<BookDto> booksDto);

}

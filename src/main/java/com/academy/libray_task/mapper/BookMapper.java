package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.*;
import com.academy.libray_task.model.entity.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class, CategoryMapper.class, PublisherMapper.class, CatalogueMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);

    List<BookDto> toDtoList(List<Book> books);

    List<Book> toEntityList(List<BookDto> booksDto);


//    @Named("catalogueToString")
//    default String toStringFromEntity(CatalogueDto catalogueDto) {
//        return catalogueDto.getName();
//    }
//    @Named("categoryToString")
//    default String toStringFromDto(CategoryDto categoryDto) {
//        return categoryDto.getName();
//    }
//    @Named("publisherToString")
//    default String toStringFromEntity(PublisherDto publisherDto) {
//        return publisherDto.getName() + " " + publisherDto.getCountry();
//    }
//    @Named("authorToString")
//    default String toStringFromDto(AuthorDto authorDto) {
//        return authorDto.getName() + " " + authorDto.getSurname();
//    }
//    String toStringFromDto(BookDto bookDto);


//    String toStringFromEntity(Book book);
//    Book toEntityFromString(String book);
//    //@Mapping(target = "authors", qualifiedBy = "authorToString")
//    String toStringFromDto(BookDto bookDto);
//    BookDto toDtoFromString(String book);

}

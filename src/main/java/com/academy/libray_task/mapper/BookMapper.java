package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.*;
import com.academy.libray_task.model.entity.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class, CategoryMapper.class, PublisherMapper.class, CatalogueMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

//    @Mappings(
//            {@Mapping(target = "authors", qualifiedByName = "authorToString"),
//                    @Mapping(target = "categories", qualifiedByName = "categoryToString"),
//                    @Mapping(target = "publisher", qualifiedByName = "publisherToString"),
//                    @Mapping(target = "catalogue", qualifiedByName = "catalogueToString")
//            })
    BookDto toDto(Book book);

//    @Mappings(
//            {@Mapping(target = "authors", ignore = true),
//                    @Mapping(target = "categories", ignore = true),
//                    @Mapping(target = "publisher", ignore = true),
//                    @Mapping(target = "catalogue", ignore = true)
//            })
    Book toEntity(BookDto bookDto);

    List<BookDto> toDtoList(List<Book> books);

    List<Book> toEntityList(List<BookDto> booksDto);


//    @Named("catalogueToString")
//    default String toStringFromEntity(Catalogue catalogue) {
//        return catalogue.getName();
//    }
//    @Named("categoryToString")
//    default String toStringFromCategories(List<Category> categories) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Category category:categories) {
//            stringBuilder.append(category.getName());
//        }
//        return stringBuilder.toString();
//    }
//    @Named("publisherToString")
//    default String toStringFromPublisher(Publisher publisher) {
//        return publisher.getName() + " " + publisher.getCountry();
//    }
//    @Named("authorToString")
//    default String toStringFromAuthors(List<Author> authors) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Author author:authors) {
//            stringBuilder.append(author.getName())
//                         .append(" ")
//                         .append(author.getSurname());
//        }
//        return stringBuilder.toString();
//    }

    //    String toStringFromDto(BookDto bookDto);


//    String toStringFromEntity(Book book);
//    Book toEntityFromString(String book);
//    //@Mapping(target = "authors", qualifiedBy = "authorToString")
//    String toStringFromDto(BookDto bookDto);
//    BookDto toDtoFromString(String book);

}

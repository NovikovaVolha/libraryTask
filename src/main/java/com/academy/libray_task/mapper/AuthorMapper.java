package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.AuthorDto;
import com.academy.libray_task.model.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface AuthorMapper {

    AuthorDto toDto(Author author);

    Author toEntity(AuthorDto authorDto);

    List<AuthorDto> toDtoList(List<Author> authors);

    List<Author> toEntityList(List<AuthorDto> authorsDto);


//    String toStringFromEntity(Author author);
//    Author toEntityFromString(String author);
//    List<String> toStringFromEntity(List<Author> authors);
//    List<Author> toEntityFromString(List<String> authors);
//
//    @Named("authorToString")
//    default String toStringFromDto(AuthorDto authorDto) {
//        return authorDto.getName() + " " + authorDto.getSurname();
//    }
//    @Named("stringToAuthor")
//    default AuthorDto toDtoFromString(String author) {
//        String[] parts = author.split(" ");
//        return AuthorDto.builder()
//                .name(parts[0])
//                .surname(parts[1])
//                .build();
//    }
//    List<String> toStringFromDto(List<AuthorDto> authorsDto);
//    List<AuthorDto> toDtoFromString(List<String> authors);

}

package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.model.entity.Catalogue;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogueMapper {

    CatalogueDto toDto(Catalogue catalogue);

    Catalogue toEntity(CatalogueDto catalogueDto);

    List<CatalogueDto> toDtoList(List<Catalogue> catalogues);

    List<Catalogue> toEntityList(List<CatalogueDto> cataloguesDto);


//    @Named("catalogueToString")
//    default String toStringFromEntity(Catalogue catalogue) {
//        return catalogue.getName();
////    }
//    @Named("stringToCatalogue")
//    default CatalogueDto toEntityFromString(String catalogue) {
//        String[] parts = catalogue.split(" ");
//        return CatalogueDto.builder()
//                .name(parts[0])
//                .build();
//    }
////    String toStringFromDto(CatalogueDto catalogueDto);
////    CatalogueDto toDtoFromString(String catalogue);

}

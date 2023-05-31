package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.model.entity.Catalogue;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogueMapper {

    CatalogueDto toDto(Catalogue catalogue);

    Catalogue toEntity(CatalogueDto catalogueDto);

    List<CatalogueDto> toDtoList(List<Catalogue> catalogues);

    List<Catalogue> toEntityList(List<CatalogueDto> cataloguesDto);

}

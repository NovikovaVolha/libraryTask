package com.academy.libray_task.mapper.enums;

import com.academy.libray_task.dto.enums.RequestStatusDto;
import com.academy.libray_task.model.entity.enums.RequestStatus;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper(componentModel = "spring")
public interface RequestStatusMapper {

    @ValueMappings({
            @ValueMapping(source = "REQUEST_CREATED", target = "ЗАЯВКА_СОЗДАНА"),
            @ValueMapping(source = "BOOK_ISSUED", target = "КНИГА_ВЫДАНА"),
            @ValueMapping(source = "BOOK_RETURNED", target = "КНИГА_ВОЗВРАЩЕНА"),
            @ValueMapping(source = "BOOK_LOST", target = "КНИГА_УТЕРЯНА")
    })
    RequestStatusDto toDto(RequestStatus requestStatus);

    @ValueMappings({
            @ValueMapping(source = "ЗАЯВКА_СОЗДАНА", target = "REQUEST_CREATED"),
            @ValueMapping(source = "КНИГА_ВЫДАНА", target = "BOOK_ISSUED"),
            @ValueMapping(source = "КНИГА_ВОЗВРАЩЕНА", target = "BOOK_RETURNED"),
            @ValueMapping(source = "КНИГА_УТЕРЯНА", target = "BOOK_LOST")
    })
    RequestStatus toEntity(RequestStatusDto requestStatusDtoDto);

}

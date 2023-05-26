package com.academy.libray_task.mapper.enums;

import com.academy.libray_task.dto.enums.RequestTypeDto;
import com.academy.libray_task.model.entity.enums.RequestType;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper(componentModel = "spring")
public interface RequestTypeMapper {

    @ValueMappings({@ValueMapping(source = "READ_IN_READING_ROOM", target = "В_ЧИТАЛЬНЫЙ_ЗАЛ"), @ValueMapping(source = "CHECK_OUT", target = "НА_РУКИ")})
    RequestTypeDto toDto(RequestType requestType);

    @ValueMappings({@ValueMapping(source = "В_ЧИТАЛЬНЫЙ_ЗАЛ", target = "READ_IN_READING_ROOM"), @ValueMapping(source = "НА_РУКИ", target = "CHECK_OUT")})
    RequestType toEntity(RequestTypeDto requestTypeDto);

}


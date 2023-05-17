package com.academy.libray_task.mapper.enums;

import com.academy.libray_task.dto.enums.RequestTypeDto;
import com.academy.libray_task.model.entity.enums.RequestType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestTypeMapper {

    RequestTypeDto toDto(RequestType requestType);

    RequestType toEntity(RequestTypeDto requestTypeDto);

}


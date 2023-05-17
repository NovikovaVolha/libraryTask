package com.academy.libray_task.mapper.enums;

import com.academy.libray_task.dto.enums.RequestStatusDto;
import com.academy.libray_task.model.entity.enums.RequestStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestStatusMapper {

    RequestStatusDto toDto(RequestStatus requestStatus);

    RequestStatus toEntity(RequestStatusDto requestStatusDtoDto);

}

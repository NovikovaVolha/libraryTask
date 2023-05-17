package com.academy.libray_task.mapper;

import com.academy.libray_task.dto.RequestDto;
import com.academy.libray_task.mapper.enums.RequestStatusMapper;
import com.academy.libray_task.mapper.enums.RequestTypeMapper;
import com.academy.libray_task.model.entity.Request;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, BookMapper.class, RequestStatusMapper.class, RequestTypeMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RequestMapper {

    RequestDto toDto(Request request);

    Request toEntity(RequestDto requestDto);

    List<RequestDto> toDtoList(List<Request> requests);

    List<Request> toEntityList(List<RequestDto> requestsDto);

}

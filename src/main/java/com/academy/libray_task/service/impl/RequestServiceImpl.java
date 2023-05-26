package com.academy.libray_task.service.impl;

import com.academy.libray_task.dto.RequestDto;
import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.dto.enums.RequestStatusDto;
import com.academy.libray_task.dto.enums.RequestTypeDto;
import com.academy.libray_task.mapper.RequestMapper;
import com.academy.libray_task.mapper.UserMapper;
import com.academy.libray_task.model.entity.Request;
import com.academy.libray_task.model.repository.RequestRepository;
import com.academy.libray_task.service.RequestService;
import com.academy.libray_task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public void save(RequestDto request) {
        requestRepository.save(requestMapper.toEntity(request));
    }

    @Override
    public List<RequestDto> findAll() {
        return requestMapper.toDtoList(requestRepository.findAll());
    }

    @Override
    public Page<RequestDto> findAllPaginated(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        Page<Request> requests = requestRepository.findAll(pageable);
        return requests.map(requestMapper::toDto);
    }

    @Override
    public RequestDto findById(Integer id) {
        return requestMapper.toDto(requestRepository.getReferenceById(id));
    }

    @Override
    public List<RequestDto> findByReader(String readerSurname) {
        List<UserDto> readers = userService.findBySurname(readerSurname);
        return requestMapper.toDtoList(requestRepository.findRequestsByReader(userMapper.toEntity(readers.get(0))));
    }

    @Override
    public List<RequestDto> findByLibrarian(String librarianSurname) {
        List<UserDto> librarians = userService.findBySurname(librarianSurname);
        return requestMapper.toDtoList(requestRepository.findRequestsByLibrarian(userMapper.toEntity(librarians.get(0))));
    }

    @Override
    public List<RequestDto> findByDateOfIssue(LocalDate dateOfIssue) {
        return null;
    }

    @Override
    public List<RequestDto> findByDateOfReturn(LocalDate dateOfReturn) {
        return null;
    }

    @Override
    public List<RequestDto> findByRequestStatus(RequestStatusDto requestStatus) {
        return null;
    }

    @Override
    public List<RequestDto> findByRequestType(RequestTypeDto requestType) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        requestRepository.deleteById(id);
    }
}

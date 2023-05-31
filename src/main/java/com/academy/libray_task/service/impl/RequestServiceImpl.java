package com.academy.libray_task.service.impl;

import com.academy.libray_task.converter.request.RequestToRequestToSaveConverter;
import com.academy.libray_task.converter.request.RequestToSaveToRequestConverter;
import com.academy.libray_task.dto.BookDto;
import com.academy.libray_task.dto.RequestDto;
import com.academy.libray_task.dto.RequestToSave;
import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.mapper.BookMapper;
import com.academy.libray_task.mapper.RequestMapper;
import com.academy.libray_task.mapper.UserMapper;
import com.academy.libray_task.model.entity.Request;
import com.academy.libray_task.model.entity.enums.RequestStatus;
import com.academy.libray_task.model.entity.enums.RequestType;
import com.academy.libray_task.model.repository.RequestRepository;
import com.academy.libray_task.service.BookService;
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
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final RequestToRequestToSaveConverter toRequestToSaveConverter;
    private final RequestToSaveToRequestConverter toRequestConverter;

    @Override
    public void save(RequestToSave requestToSave) {
        Request request = toRequestConverter.convert(requestToSave);
        assert request != null;
        requestRepository.save(request);
    }

    @Override
    public RequestToSave findToUpdate(Integer id) {
        Request request = requestRepository.getReferenceById(id);
        return toRequestToSaveConverter.convert(request);
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
    public List<RequestDto> findByBook(String title) {
        List<BookDto> books = bookService.findByTitle(title);
        return requestMapper.toDtoList(requestRepository.findRequestsByBook(bookMapper.toEntity(books.get(0))));
    }

    @Override
    public List<RequestDto> findByDateOfIssue(LocalDate dateOfIssue) {
        return requestMapper.toDtoList(requestRepository.findRequestsByDateOfIssue(dateOfIssue));
    }

    @Override
    public List<RequestDto> findByDateOfReturn(LocalDate dateOfReturn) {
        return requestMapper.toDtoList(requestRepository.findRequestsByDateOfReturn(dateOfReturn));
    }

    @Override
    public List<RequestDto> findByRequestStatus(String requestStatus) {
        List<Request> requests = switch (requestStatus) {
            case "ЗАЯВКА_СОЗДАНА" -> requestRepository.findRequestsByRequestStatus(RequestStatus.REQUEST_CREATED);
            case "КНИГА_ВЫДАНА" -> requestRepository.findRequestsByRequestStatus(RequestStatus.BOOK_ISSUED);
            case "КНИГА_ВОЗВРАЩЕНА" -> requestRepository.findRequestsByRequestStatus(RequestStatus.BOOK_RETURNED);
            case "КНИГА_УТЕРЯНА" -> requestRepository.findRequestsByRequestStatus(RequestStatus.BOOK_LOST);
            default -> throw new IllegalArgumentException("Статус " + requestStatus + " не существует!");
        };
        return requestMapper.toDtoList(requests);
    }

    @Override
    public List<RequestDto> findByRequestType(String requestType) {
        List<Request> requests = switch (requestType) {
            case "В_ЧИТАЛЬНЫЙ_ЗАЛ" -> requestRepository.findRequestsByRequestType(RequestType.READ_IN_READING_ROOM);
            case "НА_РУКИ" -> requestRepository.findRequestsByRequestType(RequestType.CHECK_OUT);
            default -> throw new IllegalArgumentException("Тип запроса " + requestType + " не существует!");
        };
        return requestMapper.toDtoList(requests);
    }

    @Override
    public void delete(Integer id) {
        requestRepository.deleteById(id);
    }

}

package com.academy.libray_task.controller;

import com.academy.libray_task.dto.RequestDto;
import com.academy.libray_task.dto.RequestToSave;
import com.academy.libray_task.dto.enums.RequestStatusDto;
import com.academy.libray_task.dto.enums.RequestTypeDto;
import com.academy.libray_task.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
@RequestMapping("/requests")
public class RequestController {

    private final RequestService requestService;
    private final UserService userService;
    private final SearchUtilService searchUtilService;
    private final BookService bookService;

    @GetMapping("/all")
    public String getAllRequests(Model model) {
        model.addAttribute("requests", requestService.findAll());
        return "request/requests";
    }

    @GetMapping("/all/page")
    public String getAllRequestsPaginated(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       Model model) {
        Page<RequestDto> requests = requestService.findAllPaginated(page, pageSize);
        model.addAttribute("requests", requests.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", requests.getTotalPages());
        model.addAttribute("totalElements", requests.getTotalElements());
        return "request/requestsPaginated";
    }

    @GetMapping("/{id}/fullInfo")
    public String getFullInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("request", requestService.findById(id));
        return "request/fullInfo";
    }

    @GetMapping("/searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("request", new RequestDto());
        return "request/searchForm";
    }

    @GetMapping("/findBy")
    public String findRequestByParameter(@RequestParam String paramName, @RequestParam String paramValue, Model model) {
        model.addAttribute("requests", searchUtilService.findRequestsByParamName(paramName, paramValue));
        return "request/searchResult";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("request", new RequestToSave());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("readers", userService.findByRole("ЧИТАТЕЛЬ"));
        model.addAttribute("librarians", userService.findByRole("БИБЛИОТЕКАРЬ"));
        model.addAttribute("requestStatuses", RequestStatusDto.values());
        model.addAttribute("requestTypes", RequestTypeDto.values());
        return "request/addForm";
    }

    @PostMapping("/save")
    public String saveRequest(@ModelAttribute RequestToSave request) {
        requestService.save(request);
        return "redirect:/requests/all/page";
    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable Integer id, Model model) {
        List<String> requestStatuses = Stream.of(RequestStatusDto.values()).map(Enum::toString).collect(Collectors.toList());
        List<String> requestTypes = Stream.of(RequestTypeDto.values()).map(Enum::toString).collect(Collectors.toList());
        model.addAttribute("request", requestService.findToUpdate(id));
        model.addAttribute("requestStatuses", requestStatuses);
        model.addAttribute("requestTypes", requestTypes);
        return "request/updateForm";
    }

    @GetMapping("/{id}/delete")
    public String deleteRequest(@PathVariable Integer id) {
        requestService.delete(id);
        return "redirect:/requests/all/page";
    }

}

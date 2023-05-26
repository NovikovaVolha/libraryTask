package com.academy.libray_task.controller;

import com.academy.libray_task.dto.PublisherDto;
import com.academy.libray_task.service.PublisherService;
import com.academy.libray_task.service.SearchUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;
    private final SearchUtilService searchUtilService;

    @GetMapping("/all")
    public String getAllPublishers(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publisher/publishers";
    }

    @GetMapping("/all/page")
    public String getAllPublishersPaginated(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                            Model model) {
        Page<PublisherDto> publishers = publisherService.findAllPaginated(page, pageSize);
        model.addAttribute("publishers", publishers.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", publishers.getTotalPages());
        model.addAttribute("totalElements", publishers.getTotalElements());
        return "publisher/publishersPaginated";
    }

    @GetMapping("/{id}/fullInfo")
    public String getFullInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("publisher", publisherService.findById(id));
        return "publisher/fullInfo";
    }

    @GetMapping("/searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("publisher", new PublisherDto());
        return "publisher/searchForm";
    }

    @GetMapping("/findBy")
    public String findCategoryByParameter(@RequestParam String paramName, @RequestParam String paramValue, Model model) {
        model.addAttribute("publishers", searchUtilService.findPublishersByParamName(paramName, paramValue));
        return "publisher/searchResult";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("publisher", new PublisherDto());
        return "publisher/addForm";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute PublisherDto publisher) {
        publisherService.save(publisher);
        return "redirect:/publishers/all/page";
    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("publisher", publisherService.findById(id));
        return "publisher/updateForm";
    }

    @PostMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Integer id) {
        publisherService.delete(id);
        return "redirect:/publishers/all/page";
    }

}

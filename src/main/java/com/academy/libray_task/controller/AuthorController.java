package com.academy.libray_task.controller;

import com.academy.libray_task.dto.AuthorDto;
import com.academy.libray_task.service.AuthorService;
import com.academy.libray_task.service.SearchUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final SearchUtilService searchUtilService;

    @GetMapping("/all")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "author/authors";
    }

    @GetMapping("/all/page")
    public String getAllAuthorsPaginated(@RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "10") Integer pageSize,
                                         Model model) {
        Page<AuthorDto> authors = authorService.findAllPaginated(page, pageSize);
        model.addAttribute("authors", authors.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", authors.getTotalPages());
        model.addAttribute("totalElements", authors.getTotalElements());
        return "author/authorsPaginated";
    }

    @GetMapping("/{id}/fullInfo")
    public String getFullInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "author/fullInfo";
    }

    @GetMapping("/searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("author", new AuthorDto());
        return "author/searchForm";
    }

    @GetMapping("/findBy")
    public String findAuthorByParameter(@RequestParam String paramName, @RequestParam String paramValue, Model model) {
        model.addAttribute("authors", searchUtilService.findAuthorsByParamName(paramName, paramValue));
        return "author/searchResult";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("author", new AuthorDto());
        return "author/addForm";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute AuthorDto author) {
        authorService.save(author);
        return "redirect:/authors/all/page";
    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "author/updateForm";
    }

    @GetMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable Integer id) {
        authorService.delete(id);
        return "redirect:/authors/all/page";
    }

}

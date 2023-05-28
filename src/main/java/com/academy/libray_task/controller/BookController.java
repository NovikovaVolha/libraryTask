package com.academy.libray_task.controller;

import com.academy.libray_task.dto.BookDto;
import com.academy.libray_task.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CatalogueService catalogueService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;
    private final SearchUtilService searchUtilService;

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/books";
    }

    @GetMapping("/all/page")
    public String getAllBooksPaginated(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       Model model) {
        Page<BookDto> books = bookService.findAllPaginated(page, pageSize);
        model.addAttribute("books", books.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", books.getTotalPages());
        model.addAttribute("totalElements", books.getTotalElements());
        return "book/booksPaginated";
    }

    @GetMapping("/{id}/fullInfo")
    public String showFullInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/fullInfo";
    }

    @GetMapping("searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("book", new BookDto());
        return "book/searchForm";
    }

    @GetMapping("/findBy")
    public String findBookByParameter(@RequestParam String paramName, @RequestParam String paramValue, Model model) {
        model.addAttribute("books", searchUtilService.findBooksByParamName(paramName, paramValue));
        return "book/searchResult";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("book", new BookDto());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("catalogues", catalogueService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "book/addForm";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute BookDto book) {
        bookService.save(book);
        return "redirect:/books/all/page";
    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/updateForm";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
        return "redirect:/books/all/page";
    }

}

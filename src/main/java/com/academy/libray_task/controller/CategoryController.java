package com.academy.libray_task.controller;

import com.academy.libray_task.dto.CategoryDto;
import com.academy.libray_task.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/categories";
    }

    @GetMapping("/all/page")
    public String getAllCategoriesPaginated(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                            Model model) {
        Page<CategoryDto> categories = categoryService.findAllPaginated(page, pageSize);
        model.addAttribute("categories", categories.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", categories.getTotalPages());
        model.addAttribute("totalElements", categories.getTotalElements());
        return "category/categoriesPaginated";
    }

    @GetMapping("/{id}/fullInfo")
    public String showFullInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/fullInfo";
    }

    @GetMapping("/searchForm")
    public String showSearchForm(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "category/searchForm";
    }

    @GetMapping("/findByName")
    public String findCategoryByName(@RequestParam String name, Model model) {
        model.addAttribute("categories", categoryService.findByName(name));
        return "category/searchResult";
    }

    @GetMapping("/addForm")
    public String showAddForm(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "category/addForm";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute CategoryDto category) {
        categoryService.save(category);
        return "redirect:/categories/all/page";
    }

    @GetMapping("/{id}/updateForm")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/updateForm";
    }

    @PostMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.delete(id);
        return "redirect:/categories/all/page";
    }

//    @GetMapping("/{id}/delete")
//    public String deleteCategory(@PathVariable Integer id){
//        categoryService.delete(id);
//        return "redirect:/categories/all/page";
//    }

}

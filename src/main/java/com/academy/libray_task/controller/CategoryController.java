package com.academy.libray_task.controller;

import com.academy.libray_task.dto.CategoryDto;
import com.academy.libray_task.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String getAllCategories(Model model){
        List<CategoryDto> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/categories";
    }

    @GetMapping("/page/{page}")
    public String getAllCategoriesPaginated(@PathVariable Integer page,
                                            @RequestParam Integer pageSize,
                                            Model model){
        List<CategoryDto> categories = categoryService.findAllPaginated(page,pageSize);
        model.addAttribute("categories", categories);
        return "category/categoriesPaginated";
    }

    @GetMapping("/search")
    public String getSearchForm(Model model){
        model.addAttribute("category", new CategoryDto());
        return "category/searchForm";
    }

    @GetMapping("/find")
    public String getCategoryByName(@RequestParam String name, Model model){
        List<CategoryDto> categories = categoryService.findByName(name);
        model.addAttribute("categories", categories);
        return "category/fullInfo";
    }

    @GetMapping("/create")
    public String createCategory(Model model){
        CategoryDto category = new CategoryDto();
        model.addAttribute("category", category);
        return "category/addForm";
    }

    @PostMapping("/submit")
    public String saveCategory(@ModelAttribute CategoryDto category){
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id}/update")
    public String updateCategory(@PathVariable Integer id, Model model){
        CategoryDto category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/updateForm";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Integer id){
        CategoryDto category = categoryService.findById(id);
        categoryService.delete(category);
        return "redirect:/categories";
    }

//    @DeleteMapping("/delete")
//    public void deleteCategory(@RequestParam Integer id){
//        CategoryDto category = categoryService.findById(id);
//        categoryService.delete(category);
//    }

}

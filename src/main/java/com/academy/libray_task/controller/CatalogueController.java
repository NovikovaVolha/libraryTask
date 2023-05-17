package com.academy.libray_task.controller;

import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.service.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogues")
public class CatalogueController {

    private final CatalogueService catalogueService;

    @GetMapping
    public String getAllCatalogues(Model model) {
        List<CatalogueDto> catalogues = catalogueService.findAll();
        model.addAttribute("catalogues", catalogues);
        return "catalogue/catalogue";
    }

    @GetMapping("/add")
    public String showCatalogueAddForm(Model model) {
        CatalogueDto catalogue = new CatalogueDto();
        model.addAttribute("catalogue", catalogue);
        return "catalogue/addForm";
    }

    @PostMapping("/save")
    public String saveCatalogue(@ModelAttribute CatalogueDto catalogue) {
        catalogueService.save(catalogue);
        return "redirect:catalogues";
    }

    @GetMapping("/update/{id}")
    public String showCatalogueUpdateForm(@PathVariable Integer id, Model model) {
        CatalogueDto catalogue = catalogueService.findById(id);
        model.addAttribute("catalogue", catalogue);
        return "catalogue/updateForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteCatalogue(@PathVariable Integer id) {
        catalogueService.delete(id);
        return "redirect:catalogues";
    }

}

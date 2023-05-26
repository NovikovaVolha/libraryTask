package com.academy.libray_task.controller;

import com.academy.libray_task.dto.CatalogueDto;
import com.academy.libray_task.service.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/catalogues")
public class CatalogueController {

    private final CatalogueService catalogueService;

    @GetMapping("/all")
    public String getAllCatalogues(Model model) {
        model.addAttribute("catalogues", catalogueService.findAll());
        return "catalogue/catalogues";
    }

    @GetMapping("/all/page")
    public String getAllCataloguesPaginated(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                            Model model) {
        Page<CatalogueDto> catalogues = catalogueService.findAllPaginated(page, pageSize);
        model.addAttribute("catalogues", catalogues.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", catalogues.getTotalPages());
        model.addAttribute("totalElements", catalogues.getTotalElements());
        return "catalogue/cataloguesPaginated";
    }

    @GetMapping("/{id}/fullInfo")
    public String getFullInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("catalogue", catalogueService.findById(id));
        return "catalogue/fullInfo";
    }

    @GetMapping("searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("catalogue", new CatalogueDto());
        return "catalogue/searchForm";
    }

    @GetMapping("/findByName")
    public String findCatalogueByName(@RequestParam String name, Model model) {
        model.addAttribute("catalogues", catalogueService.findByName(name));
        return "catalogue/searchResult";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("catalogue", new CatalogueDto());
        return "catalogue/addForm";
    }

    @PostMapping("/save")
    public String saveCatalogue(@ModelAttribute CatalogueDto catalogue) {
        catalogueService.save(catalogue);
        return "redirect:/catalogues/all/page";
    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("catalogue", catalogueService.findById(id));
        return "catalogue/updateForm";
    }

    @PostMapping("/{id}/delete")
    public String deleteCatalogue(@PathVariable Integer id) {
        catalogueService.delete(id);
        return "redirect:/catalogues/all/page";
    }

}

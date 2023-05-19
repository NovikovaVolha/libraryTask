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
//@RequestMapping("catalogues")
public class CatalogueController {

    private final CatalogueService catalogueService;

    @GetMapping("/catalogues")
    public String getAllCatalogues(Model model) {
        List<CatalogueDto> catalogues = catalogueService.findAll();
        model.addAttribute("catalogues", catalogues);
        return "catalogue/catalogue";
    }

    @GetMapping("/catalogues/page")
    public String getAllCataloguesPaginated(@RequestParam(defaultValue = "1") Integer pageNumber,
                                            @RequestParam(defaultValue = "2") Integer pageSize,
                                            Model model){
        List<CatalogueDto> catalogues = catalogueService.findAllPaginated(pageNumber, pageSize);
        Integer totalElements = catalogues.size();
        Integer totalPages = (totalElements/pageSize) + 1;
        model.addAttribute("catalogues", catalogues);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);
        return "catalogue/cataloguePaginated";
    }

    @GetMapping("catalogues/search")
    public String showCatalogueSearchForm(Model model){
        model.addAttribute("catalogue", new CatalogueDto());
        return "catalogue/searchForm";
    }

    @GetMapping("catalogues/find")
    public String findCatalogueByName(@RequestParam String name, Model model){
        List<CatalogueDto> catalogue = catalogueService.findByName(name);
        model.addAttribute("catalogueByName", catalogue);
        return "catalogue/catalogueFullInfo";
    }

    @GetMapping("/catalogues/add")
    public String showCatalogueAddForm(Model model) {
        CatalogueDto catalogue = new CatalogueDto();
        model.addAttribute("catalogue", catalogue);
        return "catalogue/addForm";
    }

    @GetMapping("/catalogues/{id}/update")
    public String showCatalogueUpdateForm(@PathVariable Integer id, Model model) {
        CatalogueDto catalogue = catalogueService.findById(id);
        model.addAttribute("catalogue", catalogue);
        return "catalogue/updateForm";
    }

    @PostMapping("/catalogues/save")
    public String saveCatalogue(@ModelAttribute CatalogueDto catalogue) {
        catalogueService.save(catalogue);
        return "redirect:/catalogues";
    }

//    @GetMapping("/catalogues/{id}/delete")
//    public String deleteCatalogue(@PathVariable Integer id, Model model) {
//        catalogueService.delete(id);
//        return "redirect:/catalogues";
//    }

    @DeleteMapping("/catalogues/{id}/delete")
    public void deleteCatalogue(@PathVariable Integer id) {
        catalogueService.delete(id);
    }

}

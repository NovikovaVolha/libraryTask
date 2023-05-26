package com.academy.libray_task.controller;

import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.dto.enums.RoleDto;
import com.academy.libray_task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/all/page")
    public String getAllUsersPaginated(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       Model model) {
        Page<UserDto> users = userService.findAllPaginated(page, pageSize);
        model.addAttribute("users", users.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("totalElements", users.getTotalElements());
        return "user/usersPaginated";
    }

    @GetMapping("/{id}/fullInfo")
    public String getFullInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user/fullInfo";
    }

    @GetMapping("/searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "user/searchForm";
    }

    @GetMapping("/findBy")
    public String findUserBy(@RequestParam String paramName, @RequestParam String paramValue, Model model) {
        if (paramName.equals("name")) {
            model.addAttribute("users", userService.findByName(paramValue));
        } else if (paramName.equals("surname")) {
            model.addAttribute("users", userService.findBySurname(paramValue));
        } else if (paramName.equals("passport")) {
            model.addAttribute("users", userService.findByPassport(paramValue));
        } else if (paramName.equals("phoneNumber")) {
            model.addAttribute("users", userService.findByPhoneNumber(paramValue));
        }
        return "user/searchResult";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("roles", RoleDto.values());
        return "user/addForm";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserDto user) {
        userService.save(user);
        return "redirect:/users/all/page";
    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user/updateForm";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users/all/page";
    }

}

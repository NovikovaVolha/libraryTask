package com.academy.libray_task.controller;

import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.dto.enums.RoleDto;
import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.service.UserService;
import com.academy.libray_task.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final UserValidator userValidator;

    @GetMapping("/")
    public String getWelcomePage() {
        return "main/welcomePage";
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("roles", RoleDto.values());
        return "main/registrationForm";
    }

    @PostMapping("/registration")
    public String createUser(@ModelAttribute UserDto user, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "redirect:/registration";
        }

        userService.registerNewUser(user);
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String getMainPage() {
        return "main/main";
    }

    @GetMapping("/profile")
    public String getProfileInfo(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userService.findById(user.getId()));
        return "main/profile";
    }

}

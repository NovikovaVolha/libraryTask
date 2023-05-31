package com.academy.libray_task.validator;

import com.academy.libray_task.dto.UserDto;
import com.academy.libray_task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto user = (UserDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Обязательное поле");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Введите от 6 до 32 символов");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Пользоваетель с таким именем уже существует");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Обязательное поле");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Введите минимум 8 символов");
        }
    }

}

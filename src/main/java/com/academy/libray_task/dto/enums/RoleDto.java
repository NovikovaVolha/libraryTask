package com.academy.libray_task.dto.enums;

public enum RoleDto {

    ROLE_READER("ЧИТАТЕЛЬ"),
    ROLE_LIBRARIAN("БИБЛИОТЕКАРЬ");

    private final String name;

    RoleDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

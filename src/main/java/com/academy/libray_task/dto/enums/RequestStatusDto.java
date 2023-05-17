package com.academy.libray_task.dto.enums;

public enum RequestStatusDto {

    REQUEST_CREATED("ЗАЯВКА СОЗДАНА"),
    BOOK_ISSUED("КНИГА ВЫДАНА"),
    BOOK_RETURNED("КНИГА ВОЗВРАЩЕНА"),
    BOOK_LOST("КНИГА УТЕРЯНА");

    private final String name;

    RequestStatusDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

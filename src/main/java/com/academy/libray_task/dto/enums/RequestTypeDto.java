package com.academy.libray_task.dto.enums;

public enum RequestTypeDto {

    READ_IN_READING_ROOM("В ЧИТАЛЬНЫЙ ЗАЛ"),
    READ_ONLINE("ОНЛАЙН"),
    CHECK_OUT("НА РУКИ");

    private final String name;

    RequestTypeDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

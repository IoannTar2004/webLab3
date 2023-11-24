package org.example.model;

import lombok.Getter;

@Getter
public enum Status {
    HIT("Попал!"), MISSED("Не попал!");

    private String status;

    Status(String status) {
        this.status = status;
    }
}

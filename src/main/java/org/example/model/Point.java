package org.example.model;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named
@RequestScoped
public class Point {
    private float x;
    private float y;
    private int r;

    @PostConstruct
    public void init() {
        x = -4;
        r = 1;
    }
}

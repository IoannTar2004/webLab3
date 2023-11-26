package org.example.model;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class DynamicPoint extends BeanPoint {

    @PostConstruct
    public void init() {
        setX(-4);
        setR(1);
    }
}

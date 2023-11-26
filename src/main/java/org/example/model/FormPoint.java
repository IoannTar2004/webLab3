package org.example.model;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Named
@SessionScoped
public class FormPoint extends BeanPoint implements Serializable {

    @PostConstruct
    public void init() {
        setX(-4);
        setR(1);
    }

    public void s() {
        Write.w(this);
    }
}

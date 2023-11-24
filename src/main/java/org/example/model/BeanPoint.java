package org.example.model;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;
import org.example.database.Database;
import org.example.database.Point;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
@Named
@SessionScoped
public class BeanPoint implements Serializable {
    private float x;
    private float y;
    private int r;

    @PostConstruct
    public void init() {
        x = -4;
        r = 1;
    }
}

package org.example.model;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import org.example.database.Database;
import org.example.database.Point;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Named
@Getter
@SessionScoped
public class Results implements Serializable {
    private List<Point> points = new LinkedList<>();

    @PostConstruct
    public void init() {
        points = new Database().getPoints();
    }
    public void add(Point point) {
        points.add(point);
    }
}

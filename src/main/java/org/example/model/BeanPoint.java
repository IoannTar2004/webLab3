package org.example.model;

import lombok.Data;

import java.io.Serializable;
@Data
public abstract class BeanPoint implements Serializable {
    private float x;
    private float y;
    private int r;

    @Override
    public String toString() {
        return "BeanPoint{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}

package org.example.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public abstract class BeanPoint implements Serializable {
    private float x;
    private float y;
    private int r;

}

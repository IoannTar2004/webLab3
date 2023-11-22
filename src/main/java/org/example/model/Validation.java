package org.example.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;

import java.util.logging.Logger;

@Data
@Named
@RequestScoped
public class Validation {

    @Inject
    private Point point;
    private String messageError;

    public void validate() {
        Logger.getLogger(String.valueOf(getClass())).info("init");
        if (point.getY() < -5 || point.getY() > 3) {
            messageError = "Введенное число \n не попадает в интервал!";
        }
    }
}

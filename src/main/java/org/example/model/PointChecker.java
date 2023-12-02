package org.example.model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.Application;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.interceptor.AroundInvoke;
import lombok.Data;
import org.example.database.Database;
import org.example.database.Point;
import org.example.dependency.Injection;
import org.example.dependency.InjectionFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Named
@SessionScoped
public class PointChecker implements Serializable {

    @Injection
    private FormPoint formPoint;
    @Injection
    private DynamicPoint dynamicPoint;
    @Injection
    private Results results;
    private String messageError;

    private boolean validate(BeanPoint point) {
        return point.getX() >= -4 && point.getX() <= 4 && point.getY() >= -5 && point.getY() <= 3 && point.getR() >= 1 && point.getR() <= 5;
    }

    public void form() {
        check(formPoint);
    }

    public void dynamic() {
        check(dynamicPoint);
    }

    private void check(BeanPoint bean) {
        InjectionFactory.inject(this);

        Point point = new Point(bean);
        point.setSendTime(new SimpleDateFormat("dd-M-yyyy kk:mm:ss").format(new Date()));
        if (!validate(bean)) {
            messageError = "Координата \n не попадает под интервал!";
            return;
        }
        messageError = "";

        long start = System.nanoTime();
        double x = bean.getX();
        double y = bean.getY();
        double r = bean.getR();

        if((x >= 0 && y >= 0 && x <= r/2 && y <= r) || (x <= 0 && y >= 0 && (x*x + y*y <= r*r/4)) || (x <= 0 && y <= 0 && (y + x >= - r/2)))
            point.setStatus(Status.HIT);
        else
            point.setStatus(Status.MISSED);

        point.setScriptTime(System.nanoTime() - start);
        results.add(point);
        Database database = new Database();
        database.add(point);
        database.commit();
    }
}
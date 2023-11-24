package org.example.model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import org.example.database.Database;
import org.example.database.Point;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Named
@SessionScoped
public class PointChecker implements Serializable {

    @Inject
    private BeanPoint beanPoint;
    @Inject
    private Results results;
    private String messageError;

    private boolean validate() {
        return !(beanPoint.getY() < -5) && !(beanPoint.getY() > 3);
    }

    public void submit() {
        Point point = new Point(beanPoint);
        point.setSendTime(new SimpleDateFormat("dd-M-yyyy kk:mm:ss").format(new Date()));
        if (!validate())
            return;

        long start = System.nanoTime();
        double x = beanPoint.getX();
        double y = beanPoint.getY();
        double r = beanPoint.getR();

        if((x >= 0 && x <= r/2 && y >= 0 && y <= r) || (x*x + y*y <= r*r) || (y + x >= - r/2))
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

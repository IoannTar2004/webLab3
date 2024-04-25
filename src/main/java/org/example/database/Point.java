package org.example.database;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.model.BeanPoint;
import org.example.model.Status;

@Entity
@Table(name = "points")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "x")
    private float x;

    @Column(name = "y")
    private float y;

    @Column(name = "r")
    private int r;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "sendTime")
    private String sendTime;

    @Column(name = "script_time")
    private long scriptTime;

    public Point(BeanPoint beanPoint) {
        this.x = beanPoint.getX();
        this.y = beanPoint.getY();
        this.r = beanPoint.getR();
    }

    public Point(float x, float y, int r, Status status, String sendTime, long scriptTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.status = status;
        this.sendTime = sendTime;
        this.scriptTime = scriptTime;
    }
}

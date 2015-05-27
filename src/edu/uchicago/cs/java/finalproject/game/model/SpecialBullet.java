package edu.uchicago.cs.java.finalproject.game.model;

import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robert on 5/27/2015.
 */
public class SpecialBullet extends Bullet {
    private final double UPGRADE_FIRE_POWER = 20.0;
    private Random unknownArc;
    int xAdapter;
    int yAdapter;

    public SpecialBullet (Falcon fal){

        super(fal);
        unknownArc = new Random();
        setColor(java.awt.Color.GREEN);


        //Will enable implementation of spreadshot on our upgraded weapon
        xAdapter = unknownArc.nextInt(45);
        yAdapter = unknownArc.nextInt(45);

        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(0, 3));
        points.add(new Point(1, -1));
        points.add(new Point(0, -2));
        points.add(new Point(-1,-1));

        assignPolarPoints(points);

        //a bullet is a little bigger, lasts a lot longer
        setExpire(15);
        setRadius(6);

        setDeltaX(fal.getDeltaX() +
                Math.cos(Math.toRadians(fal.getOrientation()+xAdapter)) * UPGRADE_FIRE_POWER);
        setDeltaY(fal.getDeltaY() + yAdapter +
                Math.sin(Math.toRadians(fal.getOrientation()+yAdapter)) * UPGRADE_FIRE_POWER);
        setCenter(fal.getCenter());




    }
}

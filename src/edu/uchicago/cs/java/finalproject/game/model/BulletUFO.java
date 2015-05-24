package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robert on 5/24/2015.
 */
public class BulletUFO extends Sprite {

    private final double UFO_FIRE_POWER = 25.0;

    private static Random R;

    public BulletUFO(UFO enemyUFO){
        super();
        R = new Random();

        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(0,3));
        points.add(new Point(1,-1));
        points.add(new Point(0,-2));
        points.add(new Point(-1,-1));

        setExpire(20);
        setRadius(10);

        setDeltaX(enemyUFO.getDeltaX() + Math.cos(Math.toRadians(enemyUFO.getOrientation())) * UFO_FIRE_POWER);
        setDeltaY(enemyUFO.getDeltaY() + Math.sin(Math.toRadians(enemyUFO.getOrientation())) * UFO_FIRE_POWER);
        setCenter(enemyUFO.getCenter());

        setOrientation(enemyUFO.getOrientation());
    }

    public void expire(){
        if (getExpire() == 0){
            CommandCenter.movFoes.remove(this);
        }
        else{
            setExpire(getExpire() - 1);
        }
    }
}

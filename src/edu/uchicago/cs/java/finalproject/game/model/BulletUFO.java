package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robert on 5/24/2015.
 */
//The witch shoots red magic.  This class is titled BulletUFO because the witch was originally a UFO.
public class BulletUFO extends Sprite {

    private final double UFO_FIRE_POWER = 35.0;
    private final int EXPLOSION_AREA = 10;

    private static Random R;

    public BulletUFO(UFO enemyUFO, int angleShot){
        super();
        R = new Random();
        setColor(Color.RED);

        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(0,1));
        points.add(new Point(1,-1));
        points.add(new Point(0,-1));
        points.add(new Point(0,0));

        assignPolarPoints(points);

        setExpire(20);
        setRadius(10);
        int spreadOrientationAdjuster = R.nextInt(360);

        setDeltaX(enemyUFO.getDeltaX() + Math.cos(Math.toRadians(enemyUFO.getOrientation()+ angleShot)) * UFO_FIRE_POWER);
        setDeltaY(enemyUFO.getDeltaY() + Math.sin(Math.toRadians(enemyUFO.getOrientation()+ angleShot)) * UFO_FIRE_POWER);
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

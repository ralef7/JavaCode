package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robert on 5/31/2015.
 */
public class Nuke extends Bullet {

    private int EXPLOSION_RADIUS = 1200;
    private final double FIRE_POWER = 10;
    private static Random R;


    public Nuke(Falcon fal){
        super(fal);
        R = new Random();

        //defined the points on a cartesean grid
        ArrayList<Point> pntCs = new ArrayList<Point>();

        //more fun view of ICBM
        pntCs.add(new Point(0,3)); //top point

        pntCs.add(new Point(1,-1));
        pntCs.add(new Point(0,-2));
        pntCs.add(new Point(-1,-1));

        assignPolarPoints(pntCs);

        //a bullet expires after 20 frames
        setExpire(30);
        setRadius(20);

        setColor(Color.BLUE);


        //everything is relative to the falcon ship that fired the bullet
        setDeltaX( fal.getDeltaX() +
                Math.cos( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
        setDeltaY( fal.getDeltaY() +
                Math.sin( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
        setCenter( fal.getCenter() );

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(fal.getOrientation());
    }

    //override the expire method - once an object expires, then remove it from the arrayList.
    public void expire(){
        if (getExpire() == 0)
            CommandCenter.movFriends.remove(this);
        else
            setExpire(getExpire() - 1);
    }
}

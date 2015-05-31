package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robert on 5/31/2015.
 */
public class NukeExplosion extends Sprite{

    private static Random R;
    public static final int NUKE_RADIUS = 1100;
    public static final int EXPLOSION_POWER = 10;

    public NukeExplosion(Nuke nuke)
    {

        R = new Random();

        //defined the points on a cartesean grid
        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(0,3)); //top point
        pntCs.add(new Point(3,0));
        pntCs.add(new Point(0,-3));
        pntCs.add(new Point(-3,0));

        assignPolarPoints(pntCs);

        //a nuke explosion expires after 20 frames
        setExpire( 1000 );
        setRadius(NUKE_RADIUS);

        setColor(Color.ORANGE);


        //everything is relative to the falcon ship that fired the bullet
        setDeltaX(nuke.getDeltaX() +
                Math.cos( Math.toRadians( nuke.getOrientation() ) ) * EXPLOSION_POWER);
        setDeltaY( nuke.getDeltaY() +
                Math.sin( Math.toRadians( nuke.getOrientation() ) ) * EXPLOSION_POWER);
        setCenter( nuke.getCenter() );

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(nuke.getOrientation());
    }

    //override the expire method - once an object expires, then remove it from the arrayList.
    public void expire(){
        if (getExpire() == 0)
            CommandCenter.movFriends.remove(this);
        else
            setExpire(getExpire() - 1);
    }
}

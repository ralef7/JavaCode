package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 5/28/2015.
 */
public class Shield extends Sprite {

    public static final double FALCON_THRUST = .65;

    public Shield()
    {
        super();
        ArrayList<Point> points = new ArrayList<Point>();

        //top of shield
        points.add(new Point(0, 27));

        //right points of shield
        points.add(new Point(5, 5));
        points.add(new Point(18, 0));
        points.add(new Point(19, -3));
        points.add(new Point(19, -6));
        points.add(new Point(17, -3));
        points.add(new Point(6, -5));
        points.add(new Point(3, -15));
        points.add(new Point(6, -18));
        points.add(new Point(3, -19));

        //left points of shield
        points.add(new Point(-3, -19));
        points.add(new Point(-6, -18));
        points.add(new Point(-3, -15));
        points.add(new Point(-6, -5));
        points.add(new Point(-17, -3));
        points.add(new Point(-20, -6));
        points.add(new Point(-20, -3));
        points.add(new Point(-18, 0));
        points.add(new Point(-5, 5));

        assignPolarPoints(points);
        setColor(Color.CYAN);
        setCenter(CommandCenter.getFalcon().getCenter());
        setRadius(CommandCenter.getFalcon().getRadius()*2);
        setOrientation(CommandCenter.getFalcon().getOrientation());
        setFadeValue(0);
    }


}

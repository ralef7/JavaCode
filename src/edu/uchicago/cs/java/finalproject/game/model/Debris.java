package edu.uchicago.cs.java.finalproject.game.model;

import edu.uchicago.cs.java.finalproject.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 5/23/2015.
 */
public class Debris extends Sprite {
    private Color color;



    public Debris(Sprite deadSprite, Point start, Point end){
        super();
        color = Color.RED;
        setExpire(5);
        setRadius(12);
        ArrayList<Point> pntCs = new ArrayList<Point>();

        //pntCs.add()  add points of debris from whatever got hit

        //everything is relative to the object that explodes
        double radius = Math.sqrt(Math.pow(start.getX() - end.getX(),2) + Math.pow((start.getY() + end.getY()),2))/2;
        Point mid = new Point((int)(start.getX() + end.getX() )/ 2, (int)(start.getY() + end.getY() )/2);
        setDeltaX(deadSprite.getDeltaX() + (mid.x - deadSprite.getCenter().x) / 6);
        setDeltaY(deadSprite.getDeltaY() + (mid.y - deadSprite.getCenter().y) / 6);

        setCenter(mid);
        setRadius((int) radius);

        double orientation = Math.atan2(start.y - mid.y, start.x - mid.x);
        setOrientation((int)Math.toDegrees(orientation));

        double[] spotLength = {1, 1};
        double[] degrees = {
                Math.PI / 2, 180 * Math.PI / 360 + Math.PI};
        setLengths(spotLength);
        setDegrees(degrees);

        setExpire(20);
        setFadeValue(200);
        this.setColor(color);
    }

    public void fadeInOut(){
        if (getFadeValue() > 20){
            setFadeValue(getFadeValue() - 10);
        }
    }

    public void move(){
        super.move();
        setOrientation(getOrientation());
    }

    public void expire(){
        if (getExpire() == 0){
            CommandCenter.movFriends.remove(this);
        }
        else{
            setExpire(getExpire() - 1);
        }
    }

}

package edu.uchicago.cs.java.finalproject.game.model;

import edu.uchicago.cs.java.finalproject.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 5/23/2015.
 */
public class Debris extends Sprite {
    private Color color;

    public Debris(Sprite deadSprite, Point startSprite, Point endSprite){
        super();
        color = Color.WHITE;
        setExpire(5);
        setRadius(12);
       // ArrayList<Point> pntCs = new ArrayList<Point>();

        //pntCs.add()  add points of debris from whatever got hit

        //everything is relative to the object that explodes
        double radius = Math.sqrt(Math.pow(startSprite.getX() - endSprite.getX(),2) + Math.pow((startSprite.getY() + endSprite.getY()),2))/2;
        Point mid = new Point((int)(startSprite.getX() + endSprite.getX() )/ 2, (int)(startSprite.getY() + endSprite.getY() )/2);
        setDeltaX(deadSprite.getDeltaX() + (mid.x - deadSprite.getCenter().x) / 6);
        setDeltaY(deadSprite.getDeltaY() + (mid.y - deadSprite.getCenter().y) / 6);

        setCenter(mid);
        setRadius((int) radius);

        double orientation = CommandCenter.getFalcon().getOrientation();
        setOrientation((int)Math.toDegrees(orientation));

        double[] spotLength = {1, 1};
        double[] degrees = {
                Math.PI / 2, 180 * Math.PI / 360 + Math.PI};
        setLengths(spotLength);
        setDegrees(degrees);

        setExpire(5);
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
            CommandCenter.movDebris.remove(this);
        }
        else{
            setExpire(getExpire() - 1);
        }
    }

}

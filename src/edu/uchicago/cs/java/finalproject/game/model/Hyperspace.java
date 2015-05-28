package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by Robert on 5/25/2015.
 */
public class Hyperspace {

    private Point teleportationPoint;
    private int xCoord;
    private int yCoord;
    private Random random;
    public Hyperspace(Falcon fal){
        xCoord = random.nextInt(1100);
        yCoord = random.nextInt(900);
        teleportationPoint = new Point(xCoord, yCoord);
        fal.setCenter(teleportationPoint);
    }


    public Point hyperJump(Falcon fal){
        return fal.getCenter();
    }
}

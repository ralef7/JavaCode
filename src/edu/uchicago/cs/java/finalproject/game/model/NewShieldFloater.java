package edu.uchicago.cs.java.finalproject.game.model;

import edu.uchicago.cs.java.finalproject.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 5/27/2015.
 */
//Running into this will set your shield life to 3.
//If you cheat, then you get the added bonus of a shield life of 5.  Up to you how you want to play the game.
public class NewShieldFloater extends NewShipFloater {

    private int nSpin;

    public NewShieldFloater(){
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();
        // top of ship
        pntCs.add(new Point(5, 5));
        pntCs.add(new Point(4,0));
        pntCs.add(new Point(5, -5));
        pntCs.add(new Point(0,-4));
        pntCs.add(new Point(-5, -5));
        pntCs.add(new Point(-4,0));
        pntCs.add(new Point(-5, 5));
        pntCs.add(new Point(0,4));

        assignPolarPoints(pntCs);

        setExpire(250);
        setRadius(50);
        setColor(Color.CYAN);

        //set random DeltaX slightly different from others
        int nX = Game.R.nextInt(22);
        if (nX % 2 == 0)
            setDeltaX(nX);
        else
            setDeltaX(-nX);

        //set rnadom DeltaY tweaked from other floaters
        int nY = Game.R.nextInt(25);
        if (nY % 2 == 0)
            setDeltaX(nY);
        else
            setDeltaX(-nY);

        //set random spin tweaked from other floaters
        int nS = Game.R.nextInt(22);
        if (nS % 2 == 0)
            setSpin(nS);
        else
            setSpin(-nS);

        //random point on the screen
        setCenter(new Point(Game.R.nextInt(Game.DIM.width),
                Game.R.nextInt(Game.DIM.height)));

        //random orientation
        setOrientation(Game.R.nextInt(360));
    }
}

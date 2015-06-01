package edu.uchicago.cs.java.finalproject.game.model;

import edu.uchicago.cs.java.finalproject.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 5/31/2015.
 */
//Making this move faster makes it easier to catch I found. You kind of need nukes to get through the high levels.
public class NewNukeFloater extends NewShipFloater {

    public NewNukeFloater() {
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();
        // top of ship
        pntCs.add(new Point(5, 5));
        pntCs.add(new Point(4, 0));
        pntCs.add(new Point(5, -5));
        pntCs.add(new Point(0, -4));
        pntCs.add(new Point(-5, -5));
        pntCs.add(new Point(-4, 0));
        pntCs.add(new Point(-5, 5));
        pntCs.add(new Point(0, 4));

        assignPolarPoints(pntCs);

        setExpire(250);
        setRadius(50);
        setColor(Color.YELLOW);

        //set random DeltaX
        int nX = Game.R.nextInt(15);
        if (nX % 2 == 0)
            setDeltaX(nX);
        else
            setDeltaX(-nX);

        //set rnadom DeltaY
        int nY = Game.R.nextInt(100);
        if (nY % 2 == 0)
            setDeltaX(nY);
        else
            setDeltaX(-nY);

        //set random spin
        int nS = Game.R.nextInt(100);
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



package edu.uchicago.cs.java.finalproject.game.model;

import edu.uchicago.cs.java.finalproject.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 5/27/2015.
 */
//Very similar to the other floaters.
public class UpgradeWeaponFloater extends NewShipFloater {

    public UpgradeWeaponFloater(){
        super();
        ArrayList<Point> pntCs = new ArrayList<Point>();
        // floater points
        pntCs.add(new Point(5, 5));
        pntCs.add(new Point(4,0));
        pntCs.add(new Point(5, -5));
        pntCs.add(new Point(0,-4));
        pntCs.add(new Point(-5, -5));
        pntCs.add(new Point(-4,0));
        pntCs.add(new Point(-5, 5));
        pntCs.add(new Point(0, 4));

        assignPolarPoints(pntCs);

        //set random DekltaX slightly different from other floaters
        int nX = Game.R.nextInt(18);
        if (nX % 2 == 0){
            setDeltaX(nX);
        }
        else{
            setDeltaX(-nX);
        }

        //set random DeltaY slightly differnt from other floaters
        int nY = Game.R.nextInt(18);
        if (nY % 2 == 0){
            setDeltaX(nY);
        }
        else{
            setDeltaX(-nY);
        }

        //set random spin, again slightly different params than other floaters
        int nS = Game.R.nextInt(10);
        if (nS % 2 == 0){
            setSpin(nS);
        }
        else{
            setSpin(-nS);
        }

        setExpire(500);
        setRadius(60);

        setColor(Color.GREEN);
    }
}

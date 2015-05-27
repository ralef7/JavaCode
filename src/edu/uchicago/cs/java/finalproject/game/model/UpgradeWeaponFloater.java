package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 5/27/2015.
 */
public class UpgradeWeaponFloater extends NewShipFloater {

    public UpgradeWeaponFloater(){
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
        pntCs.add(new Point(0, 4));

        assignPolarPoints(pntCs);

        setExpire(200);
        setRadius(60);

        setColor(Color.CYAN);
    }


}

package edu.uchicago.cs.java.finalproject.game.model;

import edu.uchicago.cs.java.finalproject.controller.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Robert on 5/24/2015.
 */
public class UFO extends Sprite {



    //radius of our UFO
    private final int RAD = 30;
    private int nSpin;


    public UFO(){

        //call Sprite constructor
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();

        // top of ship
        pntCs.add(new Point(0, 14));

        //TODO: right points no idea what points of ufo should be... we'll start here
        pntCs.add(new Point(3, 3));
        pntCs.add(new Point(12, 0));
        pntCs.add(new Point(13, -2));
        pntCs.add(new Point(13, -4));
        pntCs.add(new Point(11, -2));
        pntCs.add(new Point(4, -3));
        pntCs.add(new Point(2, -10));
        pntCs.add(new Point(4, -12));
        pntCs.add(new Point(2, -13));

        //TODO: left points no idea what points for ufo should be... we'll start here
        pntCs.add(new Point(-2, -13));
        pntCs.add(new Point(-4, -12));
        pntCs.add(new Point(-2, -10));
        pntCs.add(new Point(-4, -3));
        pntCs.add(new Point(-11, -2));
        pntCs.add(new Point(-13, -4));
        pntCs.add(new Point(-13, -2));
        pntCs.add(new Point(-12, 0));
        pntCs.add(new Point(-3, 3));

        assignPolarPoints(pntCs);

        setColor(Color.RED);

        int nX = Game.R.nextInt(10);
        int nY = Game.R.nextInt(10);
        int nS = Game.R.nextInt(5);

        if (nS % 2 == 0)
            setSpin(nS);
        else
            setSpin(-nS);

        //random point on the screen to put the UFO
        setCenter(new Point(Game.R.nextInt(Game.DIM.width),
                Game.R.nextInt(Game.DIM.height)));

        //random orientation
        setOrientation(Game.R.nextInt(360));


        //random delta-x
        int nDX = Game.R.nextInt(10);
        if(nDX %2 ==0)
            nDX = -nDX;
        setDeltaX(nDX);

        //random delta-y
        int nDY = Game.R.nextInt(10);
        if(nDY %2 ==0)
            nDY = -nDY;
        setDeltaY(nDY);

        setRadius(RAD);

        setExpire(250);
    }


    //overridden
    public void move(){
        super.move();

        setOrientation(getOrientation() + getSpin());

    }

    public int getSpin() {
        return this.nSpin;
    }

    public void setSpin(int nSpin) {
        this.nSpin = nSpin;
    }

    @Override
    public void expire() {
        if (getExpire() == 0)
            CommandCenter.movFoes.remove(this);
        else
            setExpire(getExpire() - 1);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        //fill this polygon (with whatever color it has)
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
        //now draw a white border
        g.setColor(Color.RED);
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

    }


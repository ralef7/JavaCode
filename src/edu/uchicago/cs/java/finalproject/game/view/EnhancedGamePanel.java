package edu.uchicago.cs.java.finalproject.game.view;

import edu.uchicago.cs.java.finalproject.controller.Game;
import edu.uchicago.cs.java.finalproject.game.model.CommandCenter;
import edu.uchicago.cs.java.finalproject.game.model.EnhancedCommandCenter;

import java.awt.*;

/**
 * Created by Robert on 5/23/2015.
 */
//High score display.
//Wrote this when I thought 100% of the code we submitted for this assignment had to come from extending the code base.
//With the possibility of using serialization to make high scores dynamic, I decided to keep high score separate.
public class EnhancedGamePanel extends GamePanel{
    private Font highScoreFont = new Font("Times New Roman", Font.BOLD, 12);
    private int nFontWidth;
    private int nFontHeight;
    private Graphics grpOff;
    private Dimension dimOff;
    private Image imgOff;

    public EnhancedGamePanel(Dimension dim) {
        super(dim);
    }

    private void drawHighScore(Graphics g){
        g.setColor(Color.white);
        g.setFont(highScoreFont);
        if (CommandCenter.getScore() != 0) {
            g.drawString("HIGH SCORE :  " + EnhancedCommandCenter.getHighScore(), nFontWidth, nFontHeight);
        } else {
            g.drawString("NO HIGH SCORE", nFontWidth, nFontHeight);
        }

    }
    public void update(Graphics g){
        if (grpOff == null || Game.DIM.width != dimOff.width
                || Game.DIM.height != dimOff.height) {
            dimOff = Game.DIM;
            imgOff = createImage(Game.DIM.width, Game.DIM.height);
            grpOff = imgOff.getGraphics();
        }
        super.update(g);
        drawHighScore(grpOff);
        grpOff.setColor(Color.black);
        grpOff.fillRect(0, 0, Game.DIM.width, Game.DIM.height);
        }
    }



package edu.uchicago.cs.java.finalproject.game.model;

/**
 * Created by Robert on 5/23/2015.
 */
//Implemented when I thought all of our code had to extend from the base code.  This just helps in displaying and keeping track of your session's
//high score.
//TODO: make high score persistent.
public class EnhancedCommandCenter{
    private static long highScore;

    private EnhancedCommandCenter() {
        highScore = 0;
    }

    public static void setHighScore(){
        if (CommandCenter.getScore() >= highScore){
            highScore = CommandCenter.getScore();
        }
    }

    public static long getHighScore(){
        return highScore;
    }



}

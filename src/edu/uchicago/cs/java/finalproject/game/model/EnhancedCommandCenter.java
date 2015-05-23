package edu.uchicago.cs.java.finalproject.game.model;

/**
 * Created by Robert on 5/23/2015.
 */
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JLabel;

/**
 *
 * @author Shaun
 */
public class ScoreDisplay extends JLabel{
    
    private final int xPos;
    private final int yPos;
    private String score;
    
    ScoreDisplay(int xPos, int yPos, String score){
        this.xPos = xPos;
        this.yPos = yPos;
        this.score = score;
        this.setSize(xPos, yPos);
        this.setVisible(true);
    }


    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
    
    
}

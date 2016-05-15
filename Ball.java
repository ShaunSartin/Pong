/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JPanel;

/**
 *
 * @author Shaun
 */
public class Ball extends JPanel{
    
    private int xCoord;
    private int yCoord;
    private final int ballWidth;
    private final int ballHeight;
    
    Ball(int xCoord, int yCoord, int ballWidth, int ballHeight){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.ballWidth = ballWidth;
        this.ballHeight = ballHeight;
    }

    
    /* Returns 0 if the ball doesn't collide with the paddle
     *         1 if the ball collides with the paddle's left edge
     *         2 if the ball collides with the paddle's top edge
     *         3 if the ball collides with the paddle's right edge
     *         4 if the ball collides with the paddle's bottom edge
     */
    public int collidesWith(Paddle paddle){
        
        return 0;
    }
    
    public int getxCoord() {
        return xCoord;
    }

    public int getBallWidth() {
        return ballWidth;
    }

    public int getBallHeight() {
        return ballHeight;
    }
    
    public int getyCoord() {
        return yCoord;
    }
    
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

}

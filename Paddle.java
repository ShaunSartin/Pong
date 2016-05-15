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
public class Paddle extends JPanel{
    
    private final int speed;
    private final int xCoord;
    private int yCoord;
    private final int paddleWidth;
    private final int paddleHeight;
    
    Paddle(int speed, int xCoord, int yCoord, int paddleWidth, int paddleHeight){
        this.speed = speed;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.paddleWidth = paddleWidth;
        this.paddleHeight = paddleHeight;
    }

    public int getSpeed() {
        return speed;
    }    
    
    public int getxCoord() {
        return xCoord;
    }

    public int getPaddleWidth() {
        return paddleWidth;
    }

    public int getPaddleHeight() {
        return paddleHeight;
    }
    
    public int getyCoord() {
        return yCoord;
    }
    
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    
}

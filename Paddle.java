/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Shaun
 */
public class Paddle extends JPanel{
    
    private final int speed;
    private final int xCoord;
    private final int width;
    private int yCoord;
    private final int height;
    
    Paddle(int speed, int xCoord, int yCoord, int width, int height){
        this.speed = speed;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = width;
        this.height = height;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(xCoord, yCoord, width, height);
    }
    
    public int getSpeed(){
        return this.speed;
    }

    public int getxCoord() {
        return xCoord;
    }
    
    public int getyCoord() {
        return yCoord;
    }
    
    public void setyCoord(int yCoord){
        this.yCoord = yCoord;
    }
   
}

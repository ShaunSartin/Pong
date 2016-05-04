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
public class Ball extends JPanel{
    
    private int xCoord;
    private final int width;
    private int yCoord;
    private final int height;
    
    Ball(int xCoord, int width, int yCoord, int height){
        this.xCoord = xCoord;
        this.width = width;
        this.yCoord = yCoord;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(xCoord, yCoord, width, height);
    }
    
    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    
}

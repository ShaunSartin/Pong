/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.TimerTask;

/**
 *
 * @author Shaun
 */
public class BallMotion extends TimerTask{

    private final Ball ball;
    
    BallMotion(Ball ball){
        this.ball = ball;
    }
    
    @Override
    public void run() {
        ball.setxCoord(ball.getxCoord() + 1);
        ball.repaint();
    }
    
}

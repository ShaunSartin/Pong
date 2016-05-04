/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Shaun
 */
public class LeftPaddleListener implements KeyListener{

    private final Paddle paddle;
    
    LeftPaddleListener(Paddle paddle){
        this.paddle = paddle;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w'){
            //System.out.println("'" + e.getKeyChar() + "' was pressed.");
            paddle.setyCoord(paddle.getyCoord() - paddle.getSpeed());
        }
            
        else if (e.getKeyChar() == 's'){
            //System.out.println("'" + e.getKeyChar() + "' was pressed.");
            paddle.setyCoord(paddle.getyCoord() + paddle.getSpeed());
                
        }
        paddle.repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import static pong.Pong.keysPressed;

/**
 *
 * @author Shaun
 */
public class LeftPaddleListener implements KeyListener{

    private final GameField gameGrid;
    
    LeftPaddleListener(JFrame frame, GameField gameGrid){
        this.gameGrid = gameGrid;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w'){
            keysPressed.add(e.getKeyCode());
        }
            
        else if (e.getKeyChar() == 's'){
            keysPressed.add(e.getKeyCode());
        }
        gameGrid.repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed.remove(e.getKeyCode());
    }
    
}

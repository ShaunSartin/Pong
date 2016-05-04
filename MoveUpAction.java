/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Shaun
 */
public class MoveUpAction extends AbstractAction{

    private final Paddle paddle;
    
    MoveUpAction(Paddle paddle){
        this.paddle = paddle;
    }
    
    
    /* This overridden method redraws the paddle so that its new position is higher than it previously was */
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("'" + e.getActionCommand() + "' was pressed.");
        paddle.setyCoord(paddle.getyCoord() - paddle.getSpeed());
        paddle.repaint();
    }
    
}

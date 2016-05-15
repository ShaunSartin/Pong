/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyEvent;
import java.util.TimerTask;
import static pong.Pong.MAX_HEIGHT;
import static pong.Pong.isSleeping;
import static pong.Pong.keysPressed;

/**
 *
 * @author Shaun
 */
public class PaddleMotionTask extends TimerTask{

    private final GameField gameGrid;
    
    PaddleMotionTask(GameField gameGrid){
        this.gameGrid = gameGrid;
    }
    
    @Override
    public void run() {
        for(int keyCode : keysPressed){
            if (isSleeping == false){
                if ((keyCode == KeyEvent.VK_W) && (gameGrid.getLeftPaddle().getyCoord() > 0)){
                    gameGrid.getLeftPaddle().setyCoord(gameGrid.getLeftPaddle().getyCoord() - gameGrid.getLeftPaddle().getSpeed());
                }

                if (keyCode == KeyEvent.VK_S  &&(gameGrid.getLeftPaddle().getyCoord() < (MAX_HEIGHT - gameGrid.getLeftPaddle().getPaddleHeight() - 28))){
                    gameGrid.getLeftPaddle().setyCoord(gameGrid.getLeftPaddle().getyCoord() + gameGrid.getLeftPaddle().getSpeed());
                }

                if (keyCode == KeyEvent.VK_UP &&(gameGrid.getRightPaddle().getyCoord() > 0)){
                    gameGrid.getRightPaddle().setyCoord(gameGrid.getRightPaddle().getyCoord() - gameGrid.getRightPaddle().getSpeed());
                }

                if (keyCode == KeyEvent.VK_DOWN &&(gameGrid.getRightPaddle().getyCoord() < (MAX_HEIGHT - gameGrid.getRightPaddle().getPaddleHeight() - 28))){
                    gameGrid.getRightPaddle().setyCoord(gameGrid.getRightPaddle().getyCoord() + gameGrid.getRightPaddle().getSpeed());
                }
            }
        }
    }
    
}

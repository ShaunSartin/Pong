/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pong.Pong.BALL_WIDTH;
import static pong.Pong.MAX_HEIGHT;
import static pong.Pong.MAX_WIDTH;
import static pong.Pong.PADDLE_HEIGHT;
import static pong.Pong.PADDLE_WIDTH;
import static pong.Pong.isSleeping;

/**
 *
 * @author Shaun
 */
public class BallMotionTask extends TimerTask{

    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int UP = -1;
    private static final int DOWN = 1;
    
    private final GameField gameGrid;
    private final Paddle leftPaddle;
    private final Paddle rightPaddle;
    private final Ball ball;
    private int currentXDirection;
    private int currentYDirection;
    
    BallMotionTask(GameField gameGrid){
        this.gameGrid = gameGrid;
        this.leftPaddle = gameGrid.getLeftPaddle();
        this.rightPaddle = gameGrid.getRightPaddle();
        this.ball = gameGrid.getBall();
        this.currentXDirection = 1;
        this.currentYDirection = 1;
    }
    
    @Override
    public void run() {
        
        // NOTE: I know that the following if statements look pretty ugly, any ideas on how to make it easier to read?
        
        /* If the ball hits the left paddle, make it bounce to the right */
        if ((ball.getxCoord() == leftPaddle.getxCoord() + PADDLE_WIDTH) && (((ball.getyCoord() + ball.getBallHeight()) >= leftPaddle.getyCoord()) && ((ball.getyCoord()) <= (leftPaddle.getyCoord() + PADDLE_HEIGHT)))){
            currentXDirection = RIGHT;
        }
        
        /* If the ball hits the right paddle, make it bounce to the left*/
        else if (((ball.getxCoord() + ball.getBallWidth()) == rightPaddle.getxCoord()) && (((ball.getyCoord() + ball.getBallHeight()) >= rightPaddle.getyCoord()) && ((ball.getyCoord()) <= (rightPaddle.getyCoord() + PADDLE_HEIGHT)))){
            currentXDirection = LEFT;
        }
        
        /* If the ball hits the top of the left paddle, make it bounce up */
        else if (((ball.getyCoord() + ball.getBallHeight()) == leftPaddle.getyCoord()) && (((ball.getxCoord() <= (leftPaddle.getxCoord() + leftPaddle.getPaddleWidth())) && ((ball.getxCoord() >= (leftPaddle.getxCoord())))) || (((ball.getxCoord() + ball.getBallWidth()) <= (leftPaddle.getxCoord() + leftPaddle.getPaddleWidth())) && (((ball.getxCoord() + ball.getBallWidth()) >= (leftPaddle.getxCoord())))))){
            currentYDirection = UP;
        }
        
        /* If the ball hits the bottom of the left paddle, make it bounce down */
        else if ((ball.getyCoord() == (leftPaddle.getyCoord() + leftPaddle.getPaddleHeight())) && (((ball.getxCoord() <= (leftPaddle.getxCoord() + leftPaddle.getPaddleWidth())) && ((ball.getxCoord() >= (leftPaddle.getxCoord())))) || (((ball.getxCoord() + ball.getBallWidth()) <= (leftPaddle.getxCoord() + leftPaddle.getPaddleWidth())) && (((ball.getxCoord() + ball.getBallWidth()) >= (leftPaddle.getxCoord())))))){
            currentYDirection = DOWN;
        }
        
        /* If the ball hits the top of the right paddle, make it bounce up */
        else if (((ball.getyCoord() + ball.getBallHeight()) == rightPaddle.getyCoord()) && (((ball.getxCoord() <= (rightPaddle.getxCoord() + rightPaddle.getPaddleWidth())) && ((ball.getxCoord() >= (rightPaddle.getxCoord())))) || (((ball.getxCoord() + ball.getBallWidth()) <= (rightPaddle.getxCoord() + rightPaddle.getPaddleWidth())) && (((ball.getxCoord() + ball.getBallWidth()) >= (rightPaddle.getxCoord())))))){
            currentYDirection = UP;
        }
        
        /* If the ball hits the bottom of the right paddle, make it bounce down */
        else if ((ball.getyCoord() == (rightPaddle.getyCoord() + rightPaddle.getPaddleHeight())) && (((ball.getxCoord() <= (rightPaddle.getxCoord() + rightPaddle.getPaddleWidth())) && ((ball.getxCoord() >= (rightPaddle.getxCoord())))) || (((ball.getxCoord() + ball.getBallWidth()) <= (rightPaddle.getxCoord() + rightPaddle.getPaddleWidth())) && (((ball.getxCoord() + ball.getBallWidth()) >= (rightPaddle.getxCoord())))))){
            currentYDirection = DOWN;
        }
        
        /* If the ball passes the left edge of the screen, reset the ball and increment right score */
        else if((ball.getxCoord() <= -BALL_WIDTH)){
            ball.setxCoord(400);
            ball.setyCoord(230);
            
            gameGrid.getRightScore().setScore(String.valueOf(Integer.parseInt(gameGrid.getRightScore().getScore()) + 1));
            
            try {
                isSleeping = true;
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BallMotionTask.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            isSleeping = false;
        }
        
        /* If the ball passes the right edge of the screen, reset the ball and increment left score */
        else if ((ball.getxCoord() >= MAX_WIDTH)){
            ball.setxCoord(400);
            ball.setyCoord(230);

            gameGrid.getLeftScore().setScore(String.valueOf(Integer.parseInt(gameGrid.getLeftScore().getScore()) + 1));
            
            try {
                isSleeping = true;
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BallMotionTask.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            isSleeping = false;
        }
        
        /* If the ball hits the top of the screen, make it bounce down */
        if (ball.getyCoord() <= 0){
            currentYDirection = DOWN;
        }
        
        /* If the ball hits the bottom of the screen, make it bounce up */
        else if ((ball.getyCoord() + ball.getBallHeight()) >= (MAX_HEIGHT - 28)){
            currentYDirection = UP;
        }
        
        ball.setxCoord(ball.getxCoord() + currentXDirection);
        ball.setyCoord(ball.getyCoord() + currentYDirection);
        gameGrid.repaint();
    }
    
}

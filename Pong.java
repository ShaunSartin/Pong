/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.GridLayout;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pong {

    public final static int PADDLE_SPEED = 5;
    public final static int MAX_WIDTH = 800;        // The width of the game board
    public final static int MAX_HEIGHT = 500;       // The height of the game board 
    public final static int PADDLE_WIDTH = 15;
    public final static int PADDLE_HEIGHT = 100;
    public final static int BALL_WIDTH = 10;
    public final static int BALL_HEIGHT = 10;
    public final static int X_OFFSET = 15;          // The distance a paddle is from the edge of the game board
    
    public static void main(String[] args) {
        
        /* Create the screen for the game */
        JFrame gameBoard = new JFrame("PONG");
        //gameBoard.setLayout(new GridLayout(1, 3));
        gameBoard.setSize(MAX_WIDTH, MAX_HEIGHT);
        gameBoard.setResizable(false);
        gameBoard.setLocationRelativeTo(null);
        gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Create two padles and a ball by using the constants defined in lines 15 through 22 */  
        Paddle leftPaddle = new Paddle(PADDLE_SPEED, 0, 170, PADDLE_WIDTH, PADDLE_HEIGHT);
        Paddle rightPaddle = new Paddle(PADDLE_SPEED, 50, 170, PADDLE_WIDTH, PADDLE_HEIGHT);
        Ball ball = new Ball(135, BALL_WIDTH, 200, BALL_HEIGHT);
        
        /* Create Key Bindings for the paddles */
//        leftPaddle.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "leftDown");
//        leftPaddle.getActionMap().put("leftDown", new MoveDownAction(leftPaddle));
//        leftPaddle.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'), "leftUp");
//        leftPaddle.getActionMap().put("leftUp", new MoveUpAction(leftPaddle));
//        rightPaddle.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "rightDown");
//        rightPaddle.getActionMap().put("rightDown", new MoveDownAction(rightPaddle));
//        rightPaddle.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "rightUp");
//        rightPaddle.getActionMap().put("rightUp", new MoveUpAction(rightPaddle));

        /* Create and add KeyListeners to the game board */
        LeftPaddleListener leftListener = new LeftPaddleListener(leftPaddle);
        RightPaddleListener rightListener = new RightPaddleListener(rightPaddle);
        gameBoard.addKeyListener(leftListener);
        gameBoard.addKeyListener(rightListener);
        
        /* Add the paddles and the ball to the screen and make the game board visible */
        gameBoard.getContentPane().add(leftPaddle);
        gameBoard.getContentPane().add(ball);
        gameBoard.getContentPane().add(rightPaddle);
        gameBoard.setVisible(true);
        
//        Timer timer = new Timer();
//        BallMotion task = new BallMotion(ball);
//        timer.schedule(task, 1, 10);

    
    }
}
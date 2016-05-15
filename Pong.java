/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import java.util.Timer;

public class Pong {
    
    public final static int PADDLE_SPEED = 1;       // The number of pixels a paddle moves per event
    public final static int MAX_WIDTH = 800;        // The width of the game board
    public final static int MAX_HEIGHT = 500;       // The height of the game board 
    public final static int PADDLE_WIDTH = 15;
    public final static int PADDLE_HEIGHT = 100;
    public final static int BALL_WIDTH = 10;
    public final static int BALL_HEIGHT = 10;
    public final static int Y_OFFSET = 170;         // The distance a paddle is from the top of the game board
    public final static int X_OFFSET = 15;          // The distance a paddle is from the side-edge of the game board
    
    public static boolean isSleeping = false;       // Prevents the paddles from moving while the thread is asleep. Without this, the paddles could 'jump' after the ball goes into a goal.
    public static Set<Integer> keysPressed = new HashSet<>();   // Keeps track of the 'pressed status' of all the necessary keys. KeyCodes are added and removed to this set as needed.
    
    public static void main(String[] args) {
        
        /* Create the window for the game */
        JFrame frame = new JFrame("PONG");
        frame.setSize(MAX_WIDTH, MAX_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create the screen for the game and add Key Listeners for the paddles */
        /* NOTE: I don't know if it's better to use Key Listeners or Key Bindings.
         *       I've asked/looked around and heard people recommend using Key Bindings over Key Listeners and vise-versa.
         *       I'd like to know your thoughts.
         */
        GameField gameGrid = new GameField();
        frame.addKeyListener(new LeftPaddleListener(frame, gameGrid));
        frame.addKeyListener(new RightPaddleListener(frame, gameGrid));
        frame.add(gameGrid);
        frame.setVisible(true);

        /* Create timers to refresh the screen and control movement */
        Timer ballTimer = new Timer();
        Timer paddleTimer = new Timer();
        ballTimer.schedule(new BallMotionTask(gameGrid), 1000, 5);
        paddleTimer.schedule(new PaddleMotionTask(gameGrid), 0, 5);
    }
   
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import static pong.Pong.BALL_HEIGHT;
import static pong.Pong.BALL_WIDTH;
import static pong.Pong.MAX_HEIGHT;
import static pong.Pong.MAX_WIDTH;
import static pong.Pong.PADDLE_HEIGHT;
import static pong.Pong.PADDLE_SPEED;
import static pong.Pong.PADDLE_WIDTH;
import static pong.Pong.X_OFFSET;
import static pong.Pong.Y_OFFSET;


/**
 *
 * @author Shaun
 */
public class GameField extends JPanel{

    private final Paddle leftPaddle = new Paddle(PADDLE_SPEED, X_OFFSET, Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
    private final Paddle rightPaddle = new Paddle(PADDLE_SPEED, MAX_WIDTH - 6 - X_OFFSET - PADDLE_WIDTH, Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
    private final Ball ball = new Ball(400, 230, BALL_WIDTH, BALL_HEIGHT);
    private ScoreDisplay leftScore = new ScoreDisplay(100, 50, "0");
    private ScoreDisplay rightScore = new ScoreDisplay(650, 50, "0");
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);
        
        g.setColor(Color.RED);
        g.fillRect(getLeftPaddle().getxCoord(), getLeftPaddle().getyCoord(), getLeftPaddle().getPaddleWidth(), getLeftPaddle().getPaddleHeight());
        g.fillRect(getBall().getxCoord(), getBall().getyCoord(), getBall().getBallWidth(), getBall().getBallHeight());
        g.fillRect(getRightPaddle().getxCoord(), getRightPaddle().getyCoord(), getRightPaddle().getPaddleWidth(), getRightPaddle().getPaddleHeight());
        
        g.setColor(Color.BLACK);
        g.drawChars(getLeftScore().getScore().toCharArray(), 0, getLeftScore().getScore().length(), getLeftScore().getxPos(), getLeftScore().getyPos());
        g.drawChars(getRightScore().getScore().toCharArray(), 0, getRightScore().getScore().length(), getRightScore().getxPos(), getRightScore().getyPos());
    }

    public Paddle getLeftPaddle() {
        return leftPaddle;
    }

    public Paddle getRightPaddle() {
        return rightPaddle;
    }

    public Ball getBall() {
        return ball;
    }

    public ScoreDisplay getLeftScore() {
        return leftScore;
    }

    public void setLeftScore(ScoreDisplay leftScore) {
        this.leftScore = leftScore;
    }

    public ScoreDisplay getRightScore() {
        return rightScore;
    }

    public void setRightScore(ScoreDisplay rightScore) {
        this.rightScore = rightScore;
    }
}

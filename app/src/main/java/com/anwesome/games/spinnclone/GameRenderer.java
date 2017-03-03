package com.anwesome.games.spinnclone;
import android.graphics.*;

import com.anwesome.games.spinnclone.gameobjects.CircleContainer;
import com.anwesome.games.spinnclone.gameobjects.MovingBall;
import com.anwesome.games.spinnclone.gameobjects.RotatingBall;
import com.anwesome.games.spinnclone.gameobjects.ScoreIndicator;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 03/03/17.
 */
public class GameRenderer {
    private ConcurrentLinkedQueue<MovingBall> movingBalls = new ConcurrentLinkedQueue<>();
    private CircleContainer circleContainer;
    private ScoreIndicator scoreIndicator = new ScoreIndicator();
    private int render = 0;
    private boolean stop = false;
    private RotatingBall rotatingBall;
    public GameRenderer() {

    }
    public boolean stopped() {
        return stop;
    }
    public void createBalls(int w,int h) {
        MovingBall movingBall = MovingBallFactory.createMovingBall(render,w,h);
        if(movingBall!=null) {
            movingBalls.add(movingBall);
        }
        render++;
    }
    public void init(int w,int h) {

        circleContainer = CircleContainer.newInstance(w/2,(3*h)/4,w/3);
        rotatingBall = RotatingBall.newInstance(w/2,(3*h)/4,w/30,w/3);
    }

    public void draw(Canvas canvas,Paint paint) {
        circleContainer.draw(canvas,paint);
        rotatingBall.draw(canvas,paint);
        scoreIndicator.drawScore(canvas,paint);
        for(MovingBall movingBall:movingBalls) {
            movingBall.draw(canvas,paint);
            float x = movingBall.getX(),y = movingBall.getY(),r = movingBall.getR();
            if(rotatingBall.isColliding(x,y,r)) {
                stop = true;
                break;
            }
            movingBall.update();
            if(movingBall.hasDisappeared()) {
                movingBalls.remove(movingBall);
            }
        }
    }
    public void update() {
        rotatingBall.update();
    }
    public void handleTap() {
        if(rotatingBall!=null) {
            rotatingBall.handleTap();
        }
    }
}

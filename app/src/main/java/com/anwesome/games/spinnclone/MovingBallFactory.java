package com.anwesome.games.spinnclone;

import com.anwesome.games.spinnclone.gameobjects.MovingBall;

import java.util.Random;

/**
 * Created by anweshmishra on 03/03/17.
 */
public class MovingBallFactory {
    public static MovingBall createMovingBall(int time,int w,int h) {
        MovingBall movingBall = null;
        if(time % 10 == 4) {
            Random random = new Random();
            int x = (w/2-w/3)+random.nextInt(2*w/3);
            int size = h/60+(random.nextInt(h/60));
            movingBall = MovingBall.newInstance(x,0,size);
        }
        return movingBall;
    }
}

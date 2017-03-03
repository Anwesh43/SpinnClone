package com.anwesome.games.spinnclone;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;

/**
 * Created by anweshmishra on 03/03/17.
 */
public class GameView extends SurfaceView {
    private Thread gameThread;
    private boolean pause = false;
    private GameRunner gameRunner;
    public GameView(Context context) {
        super(context);
        gameRunner = new GameRunner(getHolder(),this);
        gameThread = new Thread(gameRunner);
        gameThread.start();
    }
    public void pause() {
        if(!pause) {
            gameRunner.pause();
            while (true) {
                try {
                    gameThread.join();
                    break;
                } catch (Exception ex) {

                }
            }
            pause = true;
        }
    }
    public void resume() {
        if(pause) {
            gameRunner.resume();
            gameThread.start();
            pause = false;
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            gameRunner.handleTap();
        }
        return true;
    }

}

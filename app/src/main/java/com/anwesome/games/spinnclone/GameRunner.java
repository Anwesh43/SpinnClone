package com.anwesome.games.spinnclone;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

/**
 * Created by anweshmishra on 03/03/17.
 */
public class GameRunner implements Runnable {
    private boolean isRunning = true;
    private SurfaceHolder surfaceHolder;
    private int time = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private GameRenderer gameRenderer = new GameRenderer();
    private GameView gameView;
    public GameRunner(SurfaceHolder surfaceHolder,GameView gameView) {
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }
    public void run() {
        while(isRunning) {
            if(surfaceHolder.getSurface()!=null && !surfaceHolder.getSurface().isValid()) {
                continue;
            }
            Canvas canvas = surfaceHolder.lockCanvas();
            if(time == 0) {
                gameRenderer.init(canvas.getWidth(),canvas.getHeight());
            }
            canvas.drawColor(Color.parseColor("#FFE57F"));
            gameRenderer.draw(canvas,paint);
            gameRenderer.createBalls(canvas.getWidth(),canvas.getHeight());
            gameRenderer.update();
            if(gameRenderer.stopped()) {
                gameView.pause();
            }
            surfaceHolder.unlockCanvasAndPost(canvas);
            time++;
            try {
                Thread.sleep(70);
            }
            catch(Exception ex) {

            }
        }
    }
    public void handleTap() {
        gameRenderer.handleTap();
    }
    public void pause() {
        if(isRunning) {
            isRunning = false;
        }
    }
    public void resume() {
        if(!isRunning) {
            isRunning = true;
            time = 0;
        }
    }
}

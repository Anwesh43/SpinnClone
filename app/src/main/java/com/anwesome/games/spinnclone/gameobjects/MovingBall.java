package com.anwesome.games.spinnclone.gameobjects;

import android.graphics.*;

/**
 * Created by anweshmishra on 03/03/17.
 */
public class MovingBall {
    private float x,y,r;
    private final float SPEED = 30;
    private int render = 0;
    private float h = 500;
    private boolean disappear = false;
    private MovingBall(float x,float y,float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public static MovingBall newInstance(float x,float y,float r) {
        return new MovingBall(x,y,r);
    }
    public void draw(Canvas canvas,Paint paint) {
        if(render == 0) {
            h = canvas.getHeight();
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#f44336"));
        canvas.drawCircle(x,y,r,paint);
        render++;
    }
    public float getR() {
        return this.r;
    }
    public void update() {
        y+=50;
        if(y>=h) {
            disappear = true;
        }
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public boolean hasDisappeared() {
        return disappear;
    }
    public int hashCode() {
        return (int)x+(int)y+(int)r;
    }
}

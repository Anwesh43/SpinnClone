package com.anwesome.games.spinnclone.gameobjects;

import android.graphics.*;

/**
 * Created by anweshmishra on 03/03/17.
 */
public class CircleContainer {
    private float x,y,r;
    private CircleContainer(float x,float y,float r) {
        this.x = x;
        this.y = y;
        this.r  = r;
    }
    public static CircleContainer newInstance(float x,float y,float r) {
        return new CircleContainer(x,y,r);
    }
    public void draw(Canvas canvas,Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#616161"));
        canvas.drawCircle(x,y,r,paint);
    }
}

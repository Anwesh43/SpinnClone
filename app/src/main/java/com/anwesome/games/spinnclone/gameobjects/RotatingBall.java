package com.anwesome.games.spinnclone.gameobjects;
import android.graphics.*;
/**
 * Created by anweshmishra on 03/03/17.
 */
public class RotatingBall {
    private float x,y,r,deg = 0,dir=1,l=100;
    private final float SPEED = 15;
    private RotatingBall(float x,float y,float r,float l) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.l = l;
    }
    public static RotatingBall newInstance(float x,float y,float r,float l) {
        return new RotatingBall(x,y,r,l);
    }
    public void draw(Canvas canvas,Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#2196F3"));
        canvas.save();
        canvas.translate(x,y);
        canvas.rotate(deg);
        canvas.drawCircle(0,-l,r,paint);
        canvas.restore();
    }
    public void update() {
        deg+=SPEED*dir;
        if(deg>=135) {
            deg = 90;
            dir = -1;
        }
        if(deg<=-135) {
            deg = -90;
            dir = 1;
        }

    }
    public int hashCode() {
        return (int)(31*x+31*y+deg+dir);
    }
    public void handleTap() {
        dir*=-1;
    }
    public boolean isColliding(float x,float y,float r) {
        float rx = (float)(this.x+l*Math.cos((deg-90)*Math.PI/180)),ry = (float)(this.y+l*Math.sin((deg-90)*Math.PI/180));
        boolean colliding  = x+r>=rx-this.r && x-r<=rx+this.r && y+r>=ry-this.r && y-r<=ry+this.r;
        return colliding;
    }
}

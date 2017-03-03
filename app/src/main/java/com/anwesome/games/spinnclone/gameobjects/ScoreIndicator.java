package com.anwesome.games.spinnclone.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by anweshmishra on 03/03/17.
 */
public class ScoreIndicator {
    private int score = 0;
    public void drawScore(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setTextSize(canvas.getWidth()/15);
        canvas.drawText(""+score,canvas.getWidth()/2,canvas.getHeight()/10,paint);
        score++;
    }
}

package com.example.dima1516.lineapp;

import android.view.View;
import java.util.Random;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by dima1516 on 11/01/2017.
 */

public class MyView extends View
{
    Random rdm = new Random();
    Paint paint = new Paint();
    float prevX, prevY, newX, newY;
    int color = Color.BLACK;

    public MyView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        // Procesar evento
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
            {
                this.newX = event.getX();
                this.newY = event.getY();
                this.color = Color.rgb(this.rdm.nextInt(255), this.rdm.nextInt(255), this.rdm.nextInt(255));
                break;
            }

            case MotionEvent.ACTION_MOVE:
            {
                this.prevX = event.getX();
                this.prevY = event.getY();
                this.invalidate();
                break;
            }

            case MotionEvent.ACTION_UP:
            {
                this.prevX = -1;
                this.prevY = -1;
                this.newX = -1;
                this.newY = -1;
                this.invalidate();
                break;
            }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        paint.setColor(this.color);
        canvas.drawLine(this.prevX, this.prevY, this.newX, this.newY, this.paint);
    }
}

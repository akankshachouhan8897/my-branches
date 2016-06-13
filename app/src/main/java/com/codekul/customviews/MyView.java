package com.codekul.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by aniruddha on 13/6/16.
 */
public class MyView extends EditText{

    private Paint paint;
    private int dx, dy, cx, cy, rad = 30;

    public MyView(Context context) {
        super(context);

        //called when view is created by code

        createThread();
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context,attrs);

        //called when view is created by xml

        initPaint();
    }

    private final void initPaint(){
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(cx,cy,rad,paint);
    }

    private final void pictureExample(Canvas canvas){

        Picture picture  = new Picture();

        picture.beginRecording(100,100);
        canvas.drawCircle(30,60,30,paint);
        paint.setTextSize(30);
        canvas.drawText("codekul.com",30,60,paint);
        picture.endRecording();
        picture.draw(canvas);
    }

    private final void createThread(){

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        while(true){

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if(cx >= getWidth()) dx = -5;
                            if(cx <= 0 ) dx = 5;
                            if(cy >= getHeight()) dy = -5;
                            if(cy <= 0 ) dy = 5;

                            cx += dx;
                            cy += dy;
                        }
                    }
                }
        ).start();
    }
}

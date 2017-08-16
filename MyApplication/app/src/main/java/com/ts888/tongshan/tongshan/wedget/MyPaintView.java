package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MyPaintView extends View {

    private Paint mPaint;
    private Path mPath;
    private Random random;

    private ArrayList<MyPath> list = new ArrayList<>();

    public MyPaintView(Context context) {
        super(context);
        init();
    }

    public MyPaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPath = new Path();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        random = new Random();

        list.add(new MyPath(mPath,mPaint));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.CYAN);

        for (int i = 0; i < list.size(); i++) {
            MyPath my = list.get(i);
            canvas.drawPath(my.path,my.paint);
        }
    }

    public void clear(){

        list.clear();

        init();

        invalidate();

    }

    public void changeColor(){
       Path mPath = new Path();

        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        MyPath path = new MyPath(mPath,mPaint);
        list.add(path);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取触摸动作
        int action = event.getAction();
        mPath = list.get(list.size()-1).path;
        switch (action) {
            case MotionEvent.ACTION_DOWN:  //手指按下
                mPath.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:  //手指移动
                mPath.lineTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:   //手指抬起
                mPath.lineTo(event.getX(),event.getY());
                break;
        }

        invalidate();
        return true;
    }


    class MyPath  {
        Path path;
        Paint paint;

        public MyPath(Path path, Paint paint) {
            this.path = path;
            this.paint = paint;
        }
    }
}

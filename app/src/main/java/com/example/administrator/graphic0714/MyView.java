package com.example.administrator.graphic0714;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-07-14.
 */
/* 사용자가 화면을 터치하면 MyVie상의 좌표값을 구해서 */
/* 그 포인트에 원을 그려보자. */
public class MyView extends View {
    ArrayList<Point> list=new ArrayList<Point>();
    int posX, posY;
    int width = 100;
    int height = 100;
    Paint paint; /* 색상을주거나,부가적인,직접그리지않음*/
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    /* onDraw는 지우고 다시 그린다. */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /* 원을 그리자!!*/
        for(int i=0;i<list.size();i++) {
            Point point=list.get(i);
            canvas.drawOval(new RectF(point.x, point.y, point.x + width, point.y + height), paint); /*null=paint*/ /*null=paint*/
        }
    }
}



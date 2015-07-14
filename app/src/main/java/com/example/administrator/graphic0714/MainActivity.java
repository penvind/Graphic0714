package com.example.administrator.graphic0714;

import android.app.Activity;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    ArrayList<Point>list=new ArrayList<Point>();
    String TAG;
    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.myView);
        TAG = this.getClass().getName();
    }

    public void printOval(ArrayList list) {
    /*정해진 좌표를 이용한 MyView 다시그리기*/
        //myView.posX = x;
        //myView.posY = y;
        myView.list=list;
        myView.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "나터치했어?");
        /* 터치가 발생하면 좌표를 컬렉션 객체에 담자.*/
        Point point = new Point((int) event.getX(), (int) event.getY());
        list.add(point);
        //printOval((int) event.getX(), (int) event.getY());
        printOval(list);
        return false;
    }

}

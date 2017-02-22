package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by admin on 2016/12/8.
 */

public class MoveButton extends Activity {
    final static int WRAP_CONTENT=-2;
    final static int X_MODIFY=40;
    final static int Y_MODIFY=100;

    int xSpan;
    int ySpan;

    private Button bok;
    private int i = 0;
    private TextView testtextview;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonmove);
        testtextview=(TextView)findViewById(R.id.testtextview);
        new Thread(new ThreadShow()).start();
        Button bok=(Button)this.findViewById(R.id.moveButton);
        bok.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        xSpan=(int)event.getX();
                        ySpan=(int)event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Button bok=(Button)findViewById(R.id.moveButton);
                        ViewGroup.LayoutParams lp=new AbsoluteLayout.LayoutParams(
                                WRAP_CONTENT,WRAP_CONTENT,
                                (int)event.getRawX()-xSpan-X_MODIFY,(int)event.getRawY()-ySpan-Y_MODIFY);
                        bok.setLayoutParams(lp);
                        break;
                }
                return true;
            }
        });

    }
    public boolean onKeyDown(int KeyCode, KeyEvent event){
        Button bok=(Button)this.findViewById(R.id.moveButton);
        bok.setText(KeyCode+" Down");
        return true;
    }

    public boolean onKeyUp(int KeyCode, KeyEvent event){
        Button bok=(Button)this.findViewById(R.id.moveButton);
        bok.setText(KeyCode+" up");
        return true;
    }

    public boolean onTouchEvent( MotionEvent event){
        Button bok=(Button)this.findViewById(R.id.moveButton);
        ViewGroup.LayoutParams lp= new AbsoluteLayout.LayoutParams( WRAP_CONTENT,WRAP_CONTENT,
                (int)event.getRawX()-xSpan-X_MODIFY,(int)event.getRawY()-ySpan-Y_MODIFY);
        bok.setLayoutParams(lp);
        return true;
    }

    //handler类
    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            if (msg.what==1){
                testtextview.setText(Integer.toString(i++));
            }
        };
    };
    //线程类
    class ThreadShow implements Runnable {
        @Override
        public void run(){
            while (true){
                try{
                    Thread.sleep(1000);
                    Message msg =new Message();
                    msg.what=1;
                    handler.sendMessage(msg);
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("thread error....");
                }
            }
        }
    }
}

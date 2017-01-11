package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;

/**
 * Created by admin on 2016/12/8.
 */

public class MoveButton extends Activity {
    final static int WRAP_CONTENT=-2;
    final static int X_MODIFY=40;
    final static int Y_MODIFY=100;

    int xSpan;
    int ySpan;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonmove);
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
}

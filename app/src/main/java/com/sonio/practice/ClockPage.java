package com.sonio.practice;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by admin on 2016/11/22.
 */

public class ClockPage  extends Activity{
    public int mHour;
    public int mMinute;
    public int mSecond;
    Handler hd=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 0:
                    long time= System.currentTimeMillis();
                    Calendar c= Calendar.getInstance();
                    c.setTimeInMillis(time);
                    mHour=c.get(Calendar.HOUR);
                    mMinute=c.get(Calendar.MINUTE);
                    mSecond=c.get(Calendar.SECOND);
                    TextView tv=(TextView)findViewById(R.id.TexeView01);
                    tv.setText("now time is"+String.valueOf(mHour)+
                    ":"+String.valueOf(mMinute)+":"+String.valueOf(mSecond));
            }
        }
    };
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clockpage);
        MyThread thread=new MyThread(this);
        thread.start();
    }
}

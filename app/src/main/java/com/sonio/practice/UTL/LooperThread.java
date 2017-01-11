package com.sonio.practice.UTL;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.sonio.practice.Constant;

/**
 * Created by admin on 2016/12/8.
 */

public class LooperThread extends Thread {
    public Handler hd;
    public Context context;
    public LooperThread(Context context){
        this.context=context;
    }
    public void run(){
        Looper.prepare();
        hd=new Handler(){
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                switch (msg.what){
                    case Constant.DISPLAY_TOAST:
                        Bundle b=msg.getData();
                        String msgStr =b.getString("msg");
                        Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show();
                 break;
                }
            }
        };
        Looper.loop();
    }
}

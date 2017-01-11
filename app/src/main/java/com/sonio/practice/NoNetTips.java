package com.sonio.practice;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sonio.practice.UTL.LooperThread;

import static com.sonio.practice.R.id.textView;

/**
 * Created by admin on 2016/12/8.
 */

public class NoNetTips extends Activity {
    LooperThread lt;

    Handler handler=new Handler();
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nonettips);
        TextView textView=(TextView)findViewById(R.id.tv01);
        textView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                showToast();
                            }
                        }).start();
                    }
                }
        );
//        lt = new LooperThread(this);
//        lt.start();
//        new Thread(){
//            public void run(){
//                for (int i=1;i<=2;i++){
//                    String msgStr="计算器值："+i;
//                    Bundle b=new Bundle();
//                    b.putString("msg",msgStr);
//                    Message msg=new Message();
//                    msg.setData(b);
//                    System.out.println(msg);
//                    msg.what=Constant.DISPLAY_TOAST;
//                    lt.hd.sendMessage(msg);
//                    try{
//                        Thread.sleep(3000);
//                    }catch(InterruptedException e){e.printStackTrace();}
//                }
//            }
//        }.start();

    }

    //匿名类实现线程
    public  void  showToast(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(NoNetTips.this," no net",Toast.LENGTH_SHORT).show();
            }
        });
    }



}

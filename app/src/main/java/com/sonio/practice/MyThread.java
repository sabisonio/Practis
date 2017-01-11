package com.sonio.practice;

/**
 * Created by admin on 2016/11/22.
 */

public class MyThread extends Thread {
    boolean flag=true;
    ClockPage activity;
    public MyThread(ClockPage activity){
        this.activity=activity;
    }
    public void run(){
        while (flag){
            try{
                MyThread.sleep(100);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            activity.hd.sendEmptyMessage(0);
        }
    }
}

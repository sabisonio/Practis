package com.sonio.practice;

import android.app.Activity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by admin on 2016/11/20.
 */

public class CalendarPage extends Activity{
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    public void onCreate(Bundle savedInstanceState){
        Calendar c= Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay=c.get(Calendar.DAY_OF_MONTH);
        mHour=c.get(Calendar.HOUR_OF_DAY);
        mMinute=c.get(Calendar.MINUTE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendarpage);
        showTime();
        DatePicker dp=(DatePicker)findViewById(R.id.DatePicker01);
        /*dp.init(mYear,mMonth,mDay,new DatePicker.OnDateChangedListener(){
            public void onDateChaged(DatePicker view,int year,int monthOfYear,int dayOfMonth{
                mYear=year;mMonth=monthOfYear;mDay=dayOfMonth;
                showTime();
            }
        });*/
        TimePicker tp=(TimePicker)findViewById(R.id.TimePicker01);
        tp.setIs24HourView(true);
        tp.setOnTimeChangedListener(
                new TimePicker.OnTimeChangedListener(){
                    public  void onTimeChanged( TimePicker view,int hourOfDay,int minute){
                        mHour=hourOfDay;
                        mMinute=minute;
                        showTime();
                    }
                }
        );
    }
    private void showTime(){
        TextView tv=(TextView)findViewById(R.id.textView1);
        tv.setText(
                new StringBuilder().append(mYear).append("/")
                .append(formatTime(mMonth+1)).append("/")
                .append(formatTime(mDay)).append(" ")
                .append(formatTime(mHour)).append(":")
                .append(formatTime(mMinute))
        );
    }
    private String formatTime(int i){
        String s=""+i;
        if (s.length()==1)
        {
            s="0"+s;
        }
        return s;
    }
}

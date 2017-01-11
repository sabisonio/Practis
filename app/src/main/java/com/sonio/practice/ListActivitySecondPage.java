package com.sonio.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by admin on 2016/11/24.
 */

public class ListActivitySecondPage extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivitypage);
        TextView textView=(TextView)findViewById(R.id.textView5);
        Intent intent= getIntent();
        String name =intent.getStringExtra("com.sonio.practice.name");
        textView.setText(name);
    }
}

package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.sonio.practice.UTL.Code;

/**
 * Created by sonio on 2017/1/13.
 */

public class Register_page extends Activity{
    private ImageView registerImageVIew;
    private String realCode;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        registerImageVIew=(ImageView)findViewById(R.id.registercode);
        registerImageVIew.setImageBitmap(Code.getInstance().createBitmap());
        realCode=Code.getInstance().getCode();
    }
}

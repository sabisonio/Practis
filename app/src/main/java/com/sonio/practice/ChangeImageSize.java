package com.sonio.practice;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by admin on 2016/10/30.
 */

public class ChangeImageSize extends Activity{
    ImageView iv;
    Bitmap bmp;
    int screenWidth;
    int screenHeight;
    float ScaleWidth = 1f;
    float scaleHeight = 1f;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeimagesize);
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.katongxiaodongwu_10);
        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth=dm.widthPixels;
        screenWidth=dm.heightPixels-80;
        iv=(ImageView)findViewById(R.id.imageView01);
        Button button1=(Button)findViewById(R.id.suoXiao);
        Button button2=(Button)findViewById(R.id.fangDa);
        iv.setImageBitmap(bmp);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageBitmap(scaleToFit(bmp,0.8f));
                bmp=scaleToFit(bmp,0.8f);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageBitmap(scaleToFit(bmp,1.2f));
                bmp=scaleToFit(bmp,1.2f);
            }
        });
    }
    public  static Bitmap scaleToFit(Bitmap bm,float scale){
        int width =bm.getWidth();
        int height =bm.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(scale,scale);
        Bitmap bmResult = Bitmap.createBitmap(bm,0,0,width,height,matrix,true);
        return bmResult;
    }
}

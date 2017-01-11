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
 * Created by admin on 2016/10/31.
 */

public class TurnImage extends Activity{
    ImageView iv;//声明ImageView
    Bitmap bmp;//声明Bitmap
    int screenWidth;//屏幕高度
    int screenHeight;//屏幕宽度
    float scaleWidth=1f;//屏幕宽度显示比例
    float scaleHeight=1f;//屏幕高度显示比例
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turnimage);
        bmp= BitmapFactory.decodeResource(getResources(),R.drawable.katongxiaodongwu_12);
        DisplayMetrics dm=new DisplayMetrics();//创建显示矩阵
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth=dm.widthPixels;//得到举证的宽度
        screenHeight=dm.heightPixels-80;//得到矩阵的高度
        iv=(ImageView)findViewById(R.id.TurnImage);
        Button turnLeft =(Button)findViewById(R.id.turnLeft);
        Button turnRight =(Button)findViewById(R.id.turnRight);
        iv.setImageBitmap(bmp);//为ImageView设置图片
        turnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageBitmap(rotateToFit(bmp,-90f));//左转
                bmp=rotateToFit(bmp,-90f);//调用ratateToFit方法
            }
        });
        turnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageBitmap(rotateToFit(bmp,90f));//调用函数
                bmp=rotateToFit(bmp,90f);
            }
        });
    }
    public static Bitmap rotateToFit(Bitmap bm,float degrees){
        int width = bm.getWidth();//图片宽度
        int height = bm.getHeight();//图片高度
        Matrix matrix = new Matrix();//得到Matrix引用
        matrix.postRotate(degrees);//矩阵旋转degree角度
        Bitmap bmResult=Bitmap.createBitmap(bm,0,0,width,height,matrix,true);
        return  bmResult;
    }
}

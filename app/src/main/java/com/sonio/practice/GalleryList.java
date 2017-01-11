package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by admin on 2016/11/9.
 */

public class GalleryList extends Activity{
    int[] imageIDs={R.drawable.katongxiaodongwu_11,R.drawable.katongxiaodongwu_12,
            R.drawable.katongxiaodongwu_13};
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        Gallery gl = (Gallery)this.findViewById(R.id.Gallery01);
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIDs.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //创建适配器需要重写方法
                ImageView iv = new ImageView(GalleryList.this);
                iv.setImageResource(imageIDs[position]);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                iv.setLayoutParams(new android.widget.Gallery.LayoutParams(188,250));
                return iv;
            }
        };
        gl.setAdapter(ba);
        gl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Gallery gl = (Gallery) findViewById(R.id.Gallery01);
                gl.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}

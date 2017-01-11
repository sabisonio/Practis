package com.sonio.practice;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/11/24.
 */

public class ListActivityPage extends ListActivity {
    List<String> items;
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);
        items = fillArray();
        final int[] drawableIds={R.drawable.katongxiaodongwu_16,R.drawable.katongxiaodongwu_17,
        R.drawable.katongxiaodongwu_18};
        BaseAdapter ba =new BaseAdapter() {
            @Override
            public int getCount() {
                return 3;
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
                LinearLayout ll = new LinearLayout(ListActivityPage.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setPadding(5,5,5,5);
                ImageView ii = new ImageView(ListActivityPage.this);
                ii.setImageDrawable(getResources().getDrawable(drawableIds[position]));
                ii.setScaleType(ImageView.ScaleType.FIT_XY);
                ii.setLayoutParams(new ViewGroup.LayoutParams(50,50));
                ll.addView(ii);
                TextView tv = new TextView(ListActivityPage.this);
                tv.setText(items.get(position));
                tv.setTextSize(24);
                tv.setPadding(5,5,5,5);
                tv.setGravity(Gravity.LEFT);
                ll.addView(tv);
                return ll;
            }

        };
        this.setListAdapter(ba);
    }
    private List<String> fillArray(){
        List<String> items =new ArrayList<>();
        items.add("haha");
        items.add("hehe");
        items.add("guagua");
        return items;
    }
    protected void onListItemClick(ListView l,View v,
                                   int position,long id){
        Intent intent =new Intent();
        intent.setClass(ListActivityPage.this,ListActivitySecondPage.class);
        //intent.setAction("com.sonio.practice.second");
        intent.putExtra("com.sonio.practice.name",items.get(position));
        startActivity(intent);
    }
}

package com.sonio.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.Activity;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by admin on 2016/10/27.
 */

public class Spiner extends Activity {
    final static int WRAP_CONTENT=-2;
    int[] drawableIds={R.drawable.katongxiaodongwu_07,R.drawable.katongxiaodongwu_08,R.drawable.katongxiaodongwu_09};
    int[] msgIds={R.string.katongxiaodongwu_07s,R.string.katongxiaodongwu_08s,R.string.katongxiaodongwu_09s};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinerview);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        BaseAdapter ba= new BaseAdapter() {
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
                LinearLayout ll = new LinearLayout(Spiner.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView ii = new ImageView(Spiner.this);
                ii.setImageDrawable(getResources().getDrawable(drawableIds[position]));
                ll.addView(ii);
                TextView tv = new TextView(Spiner.this);
                tv.setText(" "+getResources().getText(msgIds[position]));
                tv.setTextSize(24);
                ll.addView(tv);
                return ll;
            }
        };
        sp.setAdapter(ba);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)findViewById(R.id.textView4);
                LinearLayout ll = (LinearLayout) view;
                TextView tvn =(TextView) ll.getChildAt(1);
                StringBuilder sb= new StringBuilder();
                sb.append(getResources().getText(R.string.katongxiaodongwu_07));
                sb.append(":");
                sb.append(tvn.getText());
                tv.setText(sb.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}

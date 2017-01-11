package com.sonio.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by admin on 2016/10/23.
 */

public class ContactsList extends Activity {
    int[] drawableIds={R.drawable.katongxiaodongwu_07,R.drawable.katongxiaodongwu_08,R.drawable.katongxiaodongwu_09};
    int[] msgIds = {R.string.katongxiaodongwu_07,R.string.katongxiaodongwu_08,R.string.katongxiaodongwu_09};
    @Override
    public void onCreate(Bundle savedInstancedState){
        super.onCreate(savedInstancedState);
        setContentView(R.layout.contactslist);
        ListView listView = (ListView) findViewById(R.id.listView);
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
                LinearLayout ll = new LinearLayout(ContactsList.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setPadding(5,5,5,5);
                ImageView ii = new ImageView(ContactsList.this);
                ii.setImageDrawable(getResources().getDrawable(drawableIds[position]));
                ii.setScaleType(ImageView.ScaleType.FIT_XY);
                ii.setLayoutParams(new Gallery.LayoutParams(48,48));
                ll.addView(ii);
                TextView tv = new TextView(ContactsList.this);
                tv.setText(getResources().getText(msgIds[position]));
                tv.setTextSize(24);
                tv.setTextColor(ContactsList.this.getResources().getColor(R.color.white));
                tv.setPadding(5,5,5,5);
                tv.setGravity(Gravity.LEFT);
                ll.addView(tv);
                return ll;
            }

        };

        listView.setAdapter(ba);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(R.id.textView);
                LinearLayout ll = (LinearLayout) view;
                TextView tvn = (TextView)ll.getChildAt(1);
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getText(R.string.katongxiaodongwu_07));
                sb.append(":");
                sb.append(tvn.getText());
                String stemp = sb.toString();
                tv.setText(stemp.split("\\n")[0]);
            }
            @Override
            public  void onNothingSelected(AdapterView<?> arg0){};
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(R.id.textView);
                LinearLayout ll = (LinearLayout) view;
                TextView tvn = (TextView)ll.getChildAt(1);
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getText(R.string.katongxiaodongwu_07));
                sb.append(":");
                sb.append(tvn.getText());
                String stemp = sb.toString();
                tv.setText(stemp.split("\\n")[0]);
            }
        });
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsList.this,GalleryList.class);
                startActivity(intent);
            }
        });

    }
}

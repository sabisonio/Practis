package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by admin on 2016/10/25.
 */

public class ContactsTable extends Activity{
    int[] drawableIds={R.drawable.katongxiaodongwu_07,R.drawable.katongxiaodongwu_08,R.drawable.katongxiaodongwu_09};
    int[] nameIds={R.string.katongxiaodongwu_07,R.string.katongxiaodongwu_08,R.string.katongxiaodongwu_09};
    int[] msgIds = {R.string.katongxiaodongwu_07s,R.string.katongxiaodongwu_08s,R.string.katongxiaodongwu_09s};
    public List<? extends Map<String, ?>> generateDataList(){
        ArrayList<Map<String, Object>> list=new ArrayList<Map<String , Object>>();;
        int rowCounter=drawableIds.length;
        for(int i =0;i<=rowCounter;i++){
            HashMap<String,Object> hmap = new HashMap<String, Object>();
            hmap.put("col1",drawableIds[i]);
            hmap.put("col2",this.getResources().getString(nameIds[i]));
            hmap.put("col3",this.getResources().getString(msgIds[i]));
            list.add(hmap);
        }
        return list;
    }
    public void OnCreate(Bundle savedInstancedState){
        super.onCreate(savedInstancedState);
        setContentView(R.layout.contactstable);
        GridView gv= (GridView)this.findViewById(R.id.GridView01);
        SimpleAdapter sca = new SimpleAdapter( this, generateDataList(),R.layout.grid_row,new String[]{"col1","col2","col3"},
                new int[]{R.id.imageView01,R.id.textView2,R.id.textView3});
         gv.setAdapter(sca);
        gv.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        TextView tv = (TextView) findViewById(R.id.textView2);
                        LinearLayout ll = (LinearLayout) view;
                        TextView tvn = (TextView) ll.getChildAt(1);
                        TextView tvnL = (TextView) ll.getChildAt(1);
                        StringBuilder sb = new StringBuilder();
                        sb.append(tvn.getText());
                        sb.append(" ");
                        sb.append(tvnL.getText());
                        tv.setText(sb.toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(R.id.textView2);
                LinearLayout ll =(LinearLayout) view;
                TextView tvn = (TextView) ll.getChildAt(1);
                TextView tvnL = (TextView) ll.getChildAt(1);
                StringBuilder sb = new StringBuilder();
                sb.append(tvn.getText());
                sb.append(" ");
                sb.append(tvnL.getText());
                tv.setText(sb.toString());
            }
        });
    }
}

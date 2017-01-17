package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by sonio on 2017/1/16.
 */

public class Shouye extends Activity{
    private Spinner spinner2;
    private ArrayAdapter adapter2;
    private TextView selectedItem;
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ///动态加载布局http://blog.csdn.net/guolin_blog/article/details/12921889
        setContentView(R.layout.shouye);
        spinner2 = (Spinner)findViewById(R.id.titleDropdownList);
        //https://www.oschina.net/question/54100_33274
        //http://blog.csdn.net/a497393102/article/details/9279309
        adapter2 = ArrayAdapter.createFromResource(this,R.array.msa,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new SpinnerXMLSelectedListener());
        spinner2.setVisibility(View.VISIBLE);
        selectedItem=(TextView)findViewById(R.id.selectedItem);

    }
    class SpinnerXMLSelectedListener implements AdapterView.OnItemSelectedListener{
        public void onItemSelected(AdapterView<?> arg0,View arg1,int arg2,long arg3){
            selectedItem.setText(""+adapter2.getItem(arg2));
        }
        public void onNothingSelected(AdapterView<?> arg0){}

    }
}

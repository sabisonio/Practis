package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by admin on 2017/1/19.
 */

public class AddNewStore extends Activity {
    private Spinner provinceSpinner=null;
    private Spinner citySpinner=null;
    private Spinner countySpinner=null;
    ArrayAdapter<String> provinceAdapter=null;
    ArrayAdapter<String> cityAdapter=null;
    ArrayAdapter<String> countyAdapter=null;
    static int provincePosition=3;

    //省级选项值
    private String[] province = new String[]{"北京","上海","天津","广东"};
    //地级选项值
    private String[][] city = new String[][]{{"东城区","西城区","崇文区","宣武区"},
                                                {"长宁区","静安区","普陀区","闸北区"},
                                                {"和平区","河东区","河西区","南开区"},
                                                {"广州","深圳","韶关"}};
    //县级选项值
    private String[][][] county =new String[][][]{
            {{"无"},{"无"},{"无"},{"无"}},
            {{"无"},{"无"},{"无"},{"无"}},
            {{"无"},{"无"},{"无"},{"无"}},
            {{"海珠区","天河区","萝岗区","荔湾区"},
              {"宝安区","福田区","龙岗区","罗湖区"},
              {"武汉区","浈江区","曲江区","乐昌市"}}
    };
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewstore);
        setSpinner();
    }
    /*
    * 设置下拉框
    * */
    private  void setSpinner(){

        provinceSpinner=(Spinner)findViewById(R.id.spin_province);
        citySpinner=(Spinner)findViewById(R.id.spin_city);
        countySpinner=(Spinner)findViewById(R.id.spin_county);
        ///绑定适配器
        provinceAdapter=new ArrayAdapter<String>(AddNewStore.this,android.R.layout.simple_spinner_item,province);
        provinceSpinner.setAdapter(provinceAdapter);
        provinceSpinner.setSelection(3,true);//设置默认选中项，此处默认选中第四个值

        cityAdapter=new ArrayAdapter<String>(AddNewStore.this,android.R.layout.simple_spinner_item,city[3]);
        citySpinner.setAdapter(cityAdapter);
        citySpinner.setSelection(0,true);

        countyAdapter=new ArrayAdapter<String>(AddNewStore.this,android.R.layout.simple_spinner_item,county[3][0]);
        countySpinner.setAdapter(cityAdapter);
        citySpinner.setSelection(0,true);

        /////省级下拉改变值
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ///下拉选择完成后，传值给市级
                cityAdapter = new ArrayAdapter<String>(AddNewStore.this,android.R.layout.simple_spinner_item,city[position]);
                citySpinner.setAdapter(cityAdapter);
                ////保留选择省级数据
                provincePosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ///市级下拉改变值

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countyAdapter=new ArrayAdapter<String>(AddNewStore.this,android.R.layout.simple_spinner_item,county[provincePosition][position]);
                countySpinner.setAdapter(countyAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

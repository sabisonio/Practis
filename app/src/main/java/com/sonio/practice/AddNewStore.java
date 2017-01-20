package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
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

    }
}

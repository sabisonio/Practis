package com.sonio.practice;


import android.app.AlertDialog;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by admin on 2016/11/28.
 */

public class TabPage extends TabActivity implements TabHost.OnTabChangeListener{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        new AlertDialog.Builder(this)
                .setTitle("常识！")
                .setMessage("guodong")
                .setPositiveButton("queding",null)
                .show();

        TabHost tabHost =this.getTabHost();
        LayoutInflater.from(this).inflate(R.layout.tabpage,tabHost.getTabContentView(),true);
        TabHost.TabSpec tabFood=tabHost.newTabSpec("food").setIndicator("饮食",this.getResources().
                getDrawable(R.drawable.katongxiaodongwu_16)).setContent(R.id.tabFood);
        tabHost.addTab(tabFood);

        TabHost.TabSpec tabCloths=tabHost.newTabSpec("cloths").setIndicator("保暖",this.getResources().
                getDrawable(R.drawable.katongxiaodongwu_17)).setContent(R.id.tabCloth);
        tabHost.addTab(tabCloths);

        TabHost.TabSpec tabOutside=tabHost.newTabSpec("outside").setIndicator("出行",this.getResources().
                getDrawable(R.drawable.katongxiaodongwu_18)).setContent(R.id.tabOutside);
        tabHost.addTab(tabOutside);
        tabHost.setOnTabChangedListener(this);
        onTabChanged("food");
    }
    @Override
    public void onTabChanged(String tabId){
        if (tabId.equals("food")){
            TextView tv=(TextView)findViewById(R.id.TexeView01);
            tv.setText("hahhahahhahahh");
        }

        if (tabId.equals("cloths")){
            TextView tv=(TextView)findViewById(R.id.TexeView02);
            tv.setText("hehhehehhehehehe");
        }

        if (tabId.equals("outside")){
            TextView tv=(TextView)findViewById(R.id.TexeView03);
            tv.setText("wowoowowowowo");
        }

    }

}

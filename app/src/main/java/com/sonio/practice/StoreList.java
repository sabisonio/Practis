package com.sonio.practice;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.sonio.practice.R.id.saleid;
import static com.sonio.practice.R.id.storeName;

/**
 * Created by sonio on 2017/1/24.
 */

public class StoreList extends Activity implements AdapterView.OnItemClickListener {

    SQLiteDatabase mDb;
    SQLiteDataBaseDao dao;
    ArrayList<HashMap<String,Object>> listData;
    SimpleAdapter listItemAdapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storelistmain);
       dao=new SQLiteDataBaseDao();
        ListView list = (ListView)findViewById(R.id.list_items);
        listItemAdapter = new SimpleAdapter(StoreList.this,listData,R.layout.storelistitem,
                new String[]{"id","storename","saleid","address"},
                new  int[]{R.id.id, R.id.storename, saleid,R.id.address});
        list.setAdapter(listItemAdapter);
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Map<String,String> map=(Map<String, String>) StoreList.this.listItemAdapter.getItem(position);
        String putid=map.get("id").toString();
        String storename=map.get("storename");
        String saleid=map.get("saleid");
        String address=map.get("address");

        Bundle bundle = new Bundle();
                 bundle.putString("putid",putid);
                 bundle.putString("storename",storename);
                 bundle.putString("saleid",saleid);
                 bundle.putString("address",address);
                 Intent intent = new Intent();
                 intent.putExtras(bundle);
                 intent.setClass(StoreList.this,StoreDetail.class);
                 startActivity(intent);

    }

    ///数据库操作类
    class SQLiteDataBaseDao{
        //构造方法，class在new的时候就直接执行方法里面的操作
        public SQLiteDataBaseDao(){
            mDb = openOrCreateDatabase("sfa.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            getAllData("store");
        }
    ///查数据
    public void getAllData(String table){
        Cursor c=mDb.rawQuery("select * from " + table,null);
        int columnsSize = c.getColumnCount();
        listData = new ArrayList<HashMap<String, Object>>();
        while (c.moveToNext()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            for (int i=0;i<columnsSize;i++){
                map.put(c.getColumnName(i), c.getString(i));
            }
            listData.add(map);
        }
    }
    }
    @Override
    public void finish(){
        super.finish();
        mDb.close();
    }


}

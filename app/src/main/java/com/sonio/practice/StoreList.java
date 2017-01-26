package com.sonio.practice;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static com.sonio.practice.R.id.storeName;

/**
 * Created by sonio on 2017/1/24.
 */

public class StoreList extends Activity {

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
                new String[]{"storename","saleid","address"},
                new  int[]{R.id.storename,R.id.saleid,R.id.address});
        list.setAdapter(listItemAdapter);

    }

    ///数据库操作类
    class SQLiteDataBaseDao{
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
                map.put("id",c.getString(0));
                map.put("storename",c.getString(1));
                map.put("saleid",c.getString(2));
                map.put("address",c.getString(3));
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

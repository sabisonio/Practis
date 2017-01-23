package com.sonio.practice.UTL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by sonio on 2017/1/23.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_STORE="create table store(" +
            "id integer primary key autoincrement,"+"storename text,"+"saleid int,"+"address text)";

    private Context mContext;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_STORE);
        Toast.makeText(mContext, "成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

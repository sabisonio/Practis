package com.sonio.practice;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by admin on 2016/11/16.
 */

public class AlertDialogPage extends Activity {
    final int List_DIALOG_SIMPLE=0;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialogpage);
        EditText b =(EditText)findViewById(R.id.EditText1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(List_DIALOG_SIMPLE);
            }
        });
    }
    @Override
    public Dialog onCreateDialog(int id){
        Dialog dialog=null;
        switch (id){
            case List_DIALOG_SIMPLE:
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                b.setIcon(R.drawable.katongxiaodongwu_16);
                b.setTitle("请选择：");
                b.setSingleChoiceItems(R.array.msa, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et =(EditText)findViewById(R.id.EditText1);
                        et.setText(getResources().getStringArray(R.array.msa)[which]);
                        et.setCursorVisible(false);      //设置输入框中的光标不可见
                        et.setFocusable(false);           //无焦点
                        et.setFocusableInTouchMode(false); //触摸时也得不到焦点
                    }
                });
                b.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog=b.create();
                break;
        }
        return dialog;
    }
}

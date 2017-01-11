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
 * Created by admin on 2016/11/19.
 */

public class MultiChoicesPage extends Activity{
    final int List_DIALOG_MULTIPLE=0;
    String[] items=null;
    boolean[] mulFlags=new boolean[]{false,false,false,true};
    @Override
    public void onCreate(Bundle savedInstancedState){
        super.onCreate(savedInstancedState);
        setContentView(R.layout.multichoicespage);
        items=getResources().getStringArray(R.array.msa);
        Button b =(Button)findViewById(R.id.multiChoicesButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(List_DIALOG_MULTIPLE);
            }
        });
    }
    @Override
    public Dialog onCreateDialog(int id){
        Dialog dialog=null;
        switch (id){
            case List_DIALOG_MULTIPLE:
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                b.setIcon(R.drawable.katongxiaodongwu_15);
                b.setTitle("多选");
                b.setMultiChoiceItems(R.array.msa,
                        mulFlags,
                        new DialogInterface.OnMultiChoiceClickListener(){
                            public void onClick(DialogInterface dialog,int which,boolean isChecked){
                                mulFlags[which]=isChecked;
                                String resultMsg="选";
                                for(int i=0;i<mulFlags.length;i++){
                                    if(mulFlags[i]){
                                        resultMsg=resultMsg+items[i]+",";
                                    }
                                }
                                EditText et = (EditText)findViewById(R.id.multiChoicesText);
                                et.setText(resultMsg.substring(0,resultMsg.length()-1));
                            }
                        });
                b.setPositiveButton(
                        "确定",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog,int which){

                            }
                        }
                );
                dialog=b.create();
                break;
        }return dialog;
    }
}

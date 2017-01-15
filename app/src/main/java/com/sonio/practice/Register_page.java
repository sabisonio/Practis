package com.sonio.practice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.sonio.practice.UTL.Code;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by sonio on 2017/1/13.
 */

public class Register_page extends Activity implements View.OnClickListener{
    private String registerUsername;
    private ImageView registerImageVIew;
    private String realCode;
    private Button registersubmit;
    private EditText username_edit;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        username_edit=(EditText)findViewById(R.id.username_edit);
        registerImageVIew=(ImageView)findViewById(R.id.registercode);
        registerImageVIew.setImageBitmap(Code.getInstance().createBitmap());
        realCode=Code.getInstance().getCode();
        registersubmit=(Button)findViewById(R.id.registersubmit);
        registersubmit.setOnClickListener(this);
    }


    public void save(String inputText){
        FileOutputStream out =null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if (writer !=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
     public void onClick(View view){
         switch (view.getId()){
             case R.id.registersubmit:
                 save(realCode);
                 save(username_edit.getText().toString());
                 break;
         }
     }
}

package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by admin on 2017/1/7.
 */

public class LogInPage extends Activity implements View.OnClickListener {
    private EditText editText;
    private EditText pwdText;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        Button bt_login=(Button)findViewById(R.id.login);
        editText=(EditText)findViewById(R.id.accountText);
        pwdText=(EditText)findViewById(R.id.passwordEdit);
        bt_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                String inputText=editText.getText().toString();
                String pwdInputText=pwdText.getText().toString();
                if (inputText.equals("")||pwdInputText.equals(""))
                {
                    Toast.makeText(LogInPage.this,"请输入账号密码！",Toast.LENGTH_SHORT).show();
                }

                else if (inputText.equals("123")||pwdInputText.equals("123")){
                    Toast.makeText(LogInPage.this,"成功！",Toast.LENGTH_SHORT).show();
                }
                break;

                 default:break;
        }
    }
}

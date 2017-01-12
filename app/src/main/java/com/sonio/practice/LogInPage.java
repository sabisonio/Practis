package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sonio.practice.UTL.Code;


/**
 * Created by admin on 2017/1/7.
 */

public class LogInPage extends Activity implements View.OnClickListener {
    private EditText editText;
    private EditText pwdText;
    private Button accountCancle;
    private Button passwordClear;
    private Button bt_pwd_eye;
    private TextWatcher username_watcher;
    private TextWatcher password_watcher;
    boolean eyeOpen=false;
    private ImageView imageView;
    private String realCode;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        Button bt_login=(Button)findViewById(R.id.login);
        editText=(EditText)findViewById(R.id.accountText);
        pwdText=(EditText)findViewById(R.id.passwordEdit);
        accountCancle=(Button)findViewById(R.id.accountCancle);
        passwordClear=(Button)findViewById(R.id.passwordClear);
        bt_pwd_eye=(Button)findViewById(R.id.bt_pwd_eye);
        initWatcher();
        editText.addTextChangedListener(username_watcher);
        pwdText.addTextChangedListener(password_watcher);
        bt_login.setOnClickListener(this);
        accountCancle.setOnClickListener(this);
        passwordClear.setOnClickListener(this);
        ButtonListerner b = new ButtonListerner();
        bt_pwd_eye.setOnTouchListener(b);
        imageView=(ImageView)findViewById(R.id.iv_showcode);
        imageView.setImageBitmap(Code.getInstance().createBitmap());
        realCode=Code.getInstance().getCode();
        imageView.setOnClickListener(this);
    }


    //watcher
    private void initWatcher(){
        username_watcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                pwdText.setText("");
                if (s.length()>0){
                    accountCancle.setVisibility(View.VISIBLE);
                }
                else{
                    accountCancle.setVisibility(View.INVISIBLE);
                }

            }
        };

        password_watcher =new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()>0)
                {
                    passwordClear.setVisibility(View.VISIBLE);
                }
                else
                {
                    passwordClear.setVisibility(View.INVISIBLE);
                }
            }
        };

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
                    Toast.makeText(LogInPage.this,"成功！！",Toast.LENGTH_SHORT).show();
                }
                break;

                 default:break;

            case R.id.accountCancle:
                editText.setText("");
                pwdText.setText("");
                break;
            case R.id.passwordClear:
                pwdText.setText("");
                break;
            /*case R.id.bt_pwd_eye:
                if (eyeOpen){
                    pwdText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    eyeOpen=false;
                }
                else{
                    pwdText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    eyeOpen=true;
                }
                break;*/
            case R.id.iv_showcode:
                imageView.setImageBitmap(Code.getInstance().createBitmap());
                //realCode=Code.getInstance().getCode();
                break;



        }
    }
    class ButtonListerner implements View.OnTouchListener{
        public boolean onTouch(View view, MotionEvent event){
            if (view.getId()==R.id.bt_pwd_eye){
                if (event.getAction()==MotionEvent.ACTION_UP){
                    pwdText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    pwdText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }return false;
        }
    }

}

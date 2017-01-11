package com.sonio.practice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by admin on 2016/11/16.
 */

public class MainMenuPage extends Activity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout temp=(LinearLayout)findViewById(R.id.mainLinearLayOut);
        Drawable d=Drawable.createFromPath("E:/AndroidProject/Practice/app/src/main/res/drawable/img20161127131110");
        temp.setBackgroundDrawable(d);

        Button alertTips=(Button)findViewById(R.id.Button8);
        alertTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,AlertTips.class);
                startActivity(intent);
            }
        });

        Button alertDialogPage=(Button)findViewById(R.id.Button9);
        alertDialogPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,AlertDialogPage.class);
                startActivity(intent);
            }
        });

        Button multiChoicesPage=(Button)findViewById(R.id.Button10);
        multiChoicesPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,MultiChoicesPage.class);
                startActivity(intent);
            }
        });

        Button calendarPage=(Button)findViewById(R.id.Button11);
        calendarPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,CalendarPage.class);
                startActivity(intent);
            }
        });

        Button clockPage=(Button)findViewById(R.id.Button12);
        clockPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,ClockPage.class);
                startActivity(intent);
            }
        });

        Button listViewPage=(Button)findViewById(R.id.Button13);
        listViewPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,ListActivityPage.class);
                startActivity(intent);
            }
        });

        Button webViewPage=(Button)findViewById(R.id.Button14);
        webViewPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,WebViewPage.class);
                startActivity(intent);
            }
        });

        Button tabPage=(Button)findViewById(R.id.Button15);
        tabPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,TabPage.class);
                startActivity(intent);
            }
        });

        Button moveButton=(Button)findViewById(R.id.Button16);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,MoveButton.class);
                startActivity(intent);
            }
        });

        Button noNetTipsButton=(Button)findViewById(R.id.Button17);
        noNetTipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainMenuPage.this,LogInPage.class);
                startActivity(intent);
            }
        });
    }
}

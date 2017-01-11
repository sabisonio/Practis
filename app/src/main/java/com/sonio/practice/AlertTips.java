package com.sonio.practice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin on 2016/11/15.
 */

public class AlertTips extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerttips);
        Button alertTips = (Button) findViewById(R.id.alerttips);
        alertTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(AlertTips.this)
                        .setTitle("Warning")
                        .setMessage("you are fired！")
                        .setPositiveButton("yes",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int
                                    which) {
                            }
                        }).show();
            }
        });
    }
}

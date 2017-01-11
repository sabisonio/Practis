package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 2016/10/29.
 */

public class SpinnerAddItem extends Activity {
    ArrayList<String> alItem = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstancedState){
        super.onCreate(savedInstancedState);
        alItem.add("老虎");
        alItem.add("斑马");
        alItem.add("小鸟");
        setContentView(R.layout.spinneradditem);
        Spinner sp = (Spinner) this.findViewById(R.id.spinnerAddItem);
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return alItem.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(SpinnerAddItem.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                TextView tv= new TextView(SpinnerAddItem.this);
                tv.setText(alItem.get(position));
                tv.setTextSize(24);
                ll.addView(tv);
                return ll;
            }
        };
        sp.setAdapter(ba);
        Button addButton = (Button)findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText choice =(EditText)findViewById(R.id.EditItemt);
                String choiceValue = choice.getText().toString();

                if (choiceValue == null || choiceValue.equals("")) {
                    Toast.makeText(SpinnerAddItem.this, "不能输入空值！", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    alItem.add(choiceValue);
                }
            }
        });
    }
}

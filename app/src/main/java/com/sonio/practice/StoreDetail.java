package com.sonio.practice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by admin on 2017/1/30.
 */

public class StoreDetail extends Activity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storedetail);
        Bundle bundle =getIntent().getExtras();
        String putid =bundle.getString("putid");
        String storename =bundle.getString("storename");
        String saleid=bundle.getString("saleid");
        String address=bundle.getString("address");
        TextView textView=(TextView)findViewById(R.id.storenamedetail);
        textView.setText(storename);
        TextView textView1=(TextView)findViewById(R.id.saleiddetail);
        textView1.setText(saleid);
        TextView textView2=(TextView)findViewById(R.id.iddetail);
        textView2.setText(putid);
        TextView textView3=(TextView)findViewById(R.id.addressdetail);
        textView3.setText(address);
    }
}

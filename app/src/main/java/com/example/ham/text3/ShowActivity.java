package com.example.ham.text3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ham.text3.model.Staff;

public class ShowActivity extends AppCompatActivity {

    private TextView textShow;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView1();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData1();
    }

    void initView1(){
        textShow = (TextView) findViewById(R.id.text_show);
    }

    void initData1(){
        Intent intent = getIntent();
        name = intent.getStringExtra("Thanh");
        textShow.setText(name);
    }
}

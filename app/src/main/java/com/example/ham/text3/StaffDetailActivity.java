package com.example.ham.text3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ham.text3.model.Staff;

//import java.util.StringJoiner;

public class StaffDetailActivity extends AppCompatActivity {


    TextView textID,textName,textAge,textAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    void initView(){
        textID = (TextView) findViewById(R.id.Text_id);
        textName = (TextView) findViewById(R.id.Text_name);
        textAge = (TextView) findViewById(R.id.Text_age);
        textAddress=(TextView) findViewById(R.id.Text_address);
    }

    void initData(){
        Intent intent = getIntent();
        /*String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age",0);
        String address = intent.getStringExtra("address");*/

        Staff staff = (Staff) intent.getSerializableExtra("staff");

        textID.setText("Staff ID:" + staff.getStaffId());
        textName.setText("Staff Name:" +staff.getName());
        textAge.setText("Staff Age:"+String.valueOf(staff.getAge()));
        textAddress.setText("Staff Address:" + staff.getAddress());
    }
}

package com.example.ham.text3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ham.text3.db.DbUtils;
import com.example.ham.text3.model.Staff;

import java.util.List;

public class LyfeCydeActivity extends AppCompatActivity {

    private LinearLayout rootLayout;
    private List<Staff> staffList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyfe_cyde);
        initViews();
    }

    @Override
    protected void onStart(){
        super.onStart();
        initData();
    }

    void initViews(){
        rootLayout = (LinearLayout) findViewById(R.id.root);
    }

    void initData(){
        staffList = DbUtils.getStaffs();
        if (staffList ==null || staffList.size()<1)
            Toast.makeText(this,"There are no staffs!",Toast.LENGTH_SHORT).show();
        showStaffs1();
    }

    void showStaffs1(){
        int size = staffList.size();
        for (int i=0;i<size;i++){
            Button button =  new Button(this);
            String content = String.format(
                    "StaffId %s -  StaffName %s",
                    staffList.get(i).getStaffId(),
                    staffList.get(i).getName());
            button.setText(content);
            final int finalI=i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(this,"[i]" + finalI,Toast.LENGTH_SHORT).show();
                   showDetail(finalI);
                }
            });
            rootLayout.addView(button);
        }
    }

    void showDetail(int index){
        Staff staff = staffList.get(index);
        if (staff != null){
           // showDetail(staff.getStaffId(),staff.getName(),staff.getAge(),staff.getAddress());
            showDetail(staff);
        }
    }

    // Transfer data by singel fields
    void showDetail(String id,String name,int age,String address){
        Intent intent = new Intent(this,StaffDetailActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("name",name);
        intent.putExtra("age",age);
        intent.putExtra("address",address);
        startActivity(intent);
    }

    // Transfer data by serialize object
    void showDetail(Staff staff){
        Intent intent = new Intent(this,StaffDetailActivity.class);
        intent.putExtra("staff ",staff);
        startActivity(intent);
    }

}

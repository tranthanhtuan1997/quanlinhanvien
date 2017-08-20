package com.example.ham.text3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ham.text3.Adapter.OfficesAdapter;
import com.example.ham.text3.model.Staff;

import java.util.List;

public class OfficesActivity extends AppCompatActivity {

    private ListView lvOffices;
    private ArrayAdapter<String> officesAdapter = null;
    private String[] data = null;
    private OfficesAdapter adapter=null;
    private List<Staff> staffList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offices);
        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData2();
    }

    void initViews(){
        lvOffices= (ListView) findViewById(R.id.lv_offices);
    }
// Init Adapter
    void initData(){
        data=getResources().getStringArray(R.array.array_offices);
        if (data ==null)
            return;
        officesAdapter =new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        lvOffices.setAdapter(officesAdapter);
        lvOffices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long l) {
                Toast.makeText(OfficesActivity.this,
                        "You click on ["+index+"] has value [" + data[index]+"]",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    void initData2(){
        data=getResources().getStringArray(R.array.array_offices);
        adapter = new OfficesAdapter(this,R.layout.item_office,data);
        lvOffices.setAdapter(adapter);
        lvOffices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long l) {
                //Toast.makeText(OfficesActivity.this,
                    //    "You click on ["+index+"] has value [" + data[index]+"]",
                     //   Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OfficesActivity.this,ShowActivity.class);
                intent.putExtra("Thanh",data[index]);
               startActivity(intent);
            }
        });
    }

}

package com.example.ham.text3.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ham.text3.R;

/**
 * Created by Ham on 8/20/2017.
 */

public class OfficesAdapter extends ArrayAdapter<String> {

    private Context context;
    private int layout;
    private String[] data;

    public OfficesAdapter(@NonNull Context context, @LayoutRes int resource,String[] data) {
        super(context, resource);
        this.context=context;
        this.layout =resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // convertView = View.inflate(context, layout,parent);
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(layout,parent,false);
        }
        TextView textName =(TextView) convertView.findViewById(R.id.text_name);
        textName.setText(data[position]);
       // return super.getView(position, convertView, parent);
        return convertView;
    }

    @Override
    public int getCount() {
        return data.length;
    }
}

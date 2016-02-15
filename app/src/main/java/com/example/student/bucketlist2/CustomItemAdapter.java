package com.example.student.bucketlist2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.student.bucketlist2.R;
import com.example.student.bucketlist2.customItem;

import java.util.ArrayList;

public class CustomItemAdapter extends ArrayAdapter<customItem>{

    public CustomItemAdapter(Context context, ArrayList<customItem> list){
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        customItem customItem = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.complex_list_item, parent, false);
        }

        TextView itemText = (TextView) convertView.findViewById(R.id.complex_list_item);
        CheckBox itemCheck = (CheckBox) convertView.findViewById(R.id.completed_check);

        itemText.setText(customItem.text);
        itemCheck.setChecked(customItem.checked);
        itemCheck.setTag(position);

        return convertView;
    }

    public boolean getChecked(int position){
        customItem exampleItem = getItem(position);
        return exampleItem.checked;
    }

    public String getTextString(int position){
        return getItem(position).text;
    }

    public void setChecked(int position, boolean b){
        getItem(position).setChecked(b);
    }
}
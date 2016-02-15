package com.example.student.bucketlist2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.student.bucketlist2.R;
import com.example.student.bucketlist2.customItem;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomItemAdapter extends ArrayAdapter<customItem>{
    //code borrowed from this blog: http://lalit3686.blogspot.com/2012/06/today-i-am-going-to-show-how-to-deal.html
    private final List<customItem> list;

    public CustomItemAdapter(Context context, ArrayList<customItem> list){
        super(context, 0, list);
        this.list = list;
    }



public View getView(int position, View convertView, ViewGroup parent) {
    customItem customItem = getItem(position);
    TextView itemText = null;
    CheckBox itemCheck = null;
    if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.complex_list_item, parent, false);
        itemText = (TextView) convertView.findViewById(R.id.complex_list_item);
        itemCheck = (CheckBox) convertView.findViewById(R.id.completed_check);
        Log.i("real", "In get view for bundle------" + position);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        Gson gson = new Gson();
        String json = sharedPref.getString(Integer.toString(position), "default");
        bundleObject bundle = gson.fromJson(json, bundleObject.class);
        itemCheck.setChecked(bundle.getChecked());

        itemCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int getPosition = (Integer) buttonView.getTag();
//                Log.i("final", "Here is on check changed: position, then bool--> "+ getPosition + " " + isChecked );
                (list.get(getPosition)).setChecked(buttonView.isChecked());
            }
        });
    }
    else{
        itemText = (TextView) convertView.findViewById(R.id.complex_list_item);
        itemCheck = (CheckBox) convertView.findViewById(R.id.completed_check);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        Gson gson = new Gson();
        String json = sharedPref.getString(Integer.toString(position), "default");
        bundleObject bundle = gson.fromJson(json, bundleObject.class);
        itemCheck.setChecked(bundle.getChecked());
        Log.i("real", "In the else -----" + position);
    }
    itemText.setText(customItem.text);
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
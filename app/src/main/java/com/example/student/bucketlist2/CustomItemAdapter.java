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
//code borrowed from this blog: http://lalit3686.blogspot.com/2012/06/today-i-am-going-to-show-how-to-deal.html
    public CustomItemAdapter(Context context, ArrayList<customItem> list){
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        customItem customItem = getItem(position);
//added stuff
        ViewHolder viewHolder = null;
//end added stuff
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.complex_list_item, parent, false);
//Added stuff
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.label);
            viewHolder.checkbox = (CheckBox) convertView.findViewById(R.id.check);
            viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int getPosition = (Integer) buttonView.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                    list.get(getPosition).setSelected(buttonView.isChecked()); // Set the value of checkbox to maintain its state.
                }
            });
            convertView.setTag(viewHolder);
            convertView.setTag(R.id.label, viewHolder.text);
            convertView.setTag(R.id.check, viewHolder.checkbox);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.checkbox.setTag(position); // This line is important.

        viewHolder.text.setText(list.get(position).getName());
        viewHolder.checkbox.setChecked(list.get(position).isSelected());
//end added stuff
        return convertView;
    }
}
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
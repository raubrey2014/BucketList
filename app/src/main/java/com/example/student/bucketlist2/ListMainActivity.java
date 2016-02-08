package com.example.student.bucketlist2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.student.bucketlist2.R;

import java.util.ArrayList;

public class ListMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);
        ArrayList<String> items = new ArrayList<>();
        items.add("Test items 1");
        items.add("Test items 2");
        items.add("Test items 3");

        ArrayAdapter<String> a = new ArrayAdapter<String>(
                //The current context
                this,
                //The layout of the list item view
                R.layout.complex_list_item,
                //id of the text view
                R.id.complex_list_item,
                //Arraylist of data to be used in list
                items);

        ListView listView = (ListView) findViewById(
                R.id.bucket_list_view);
        listView.setAdapter(a);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Bucket List", "List Activity Main onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Bucket List", "List Activity Main onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Bucket List", "List Activity Main onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Bucket List", "List Activity Main onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Bucket List", "List Activity Main onStop");

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        if (checked){
            view.setEnabled(false);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
//        ListView l = (ListView) findViewById(R.id.bucket_list_view);
//        for (int i = 0; i < l.getCount(); i++){
//            View v = l.getChildAt(i);
//            CheckBox checkBox = (CheckBox) v.findViewById(R.id.completed_check);
//            savedInstanceState.putBoolean(Integer.toString(i), checkBox.isChecked());
//
//        }
//        savedInstanceState.putBoolean("IsCheckboxChecked", _myCheckbox.isChecked());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        ListView l = (ListView) findViewById(R.id.bucket_list_view);
//        for (int i = 0; i < l.getCount(); i++){
//            View v = l.getChildAt(i);
//            CheckBox checkBox = (CheckBox) v.findViewById(R.id.completed_check);
//            if (savedInstanceState.getBoolean(Integer.toString(i))){
//                checkBox.setChecked(true);
//                checkBox.setEnabled(false);
//            }
//
//        }
//        _myCheckbox.setChecked(savedInstanceState.getBoolean("IsCheckboxChecked"));
    }
}

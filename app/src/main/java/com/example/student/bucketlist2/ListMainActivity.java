package com.example.student.bucketlist2;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.bucketlist2.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ListMainActivity extends AppCompatActivity {

    CustomItemAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            Log.i("final", "HERE IN NULL");
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();
            String[] words = {"Streak The Lawn",
                    "Run up and down the lawn without clothes, make lots of merry",
                    "false"};
            Set<String> mySet = new HashSet<>(Arrays.asList(words));
            editor.putStringSet("0", mySet);
            String[] words1 = {"Streak The Lawn",
                    "Run up and down the lawn without clothes, make lots of merry",
                    "false"};
            Set<String> mySet1 = new HashSet<>(Arrays.asList(words1));
            editor.putStringSet("1", mySet1);
            String[] words2 = {"Streak The Lawn",
                    "Run up and down the lawn without clothes, make lots of merry",
                    "false"};
            Set<String> mySet2 = new HashSet<>(Arrays.asList(words2));
            editor.putStringSet("2", mySet2);
            String[] words3 = {"Streak The Lawn",
                    "Run up and down the lawn without clothes, make lots of merry",
                    "false"};
            Set<String> mySet3 = new HashSet<>(Arrays.asList(words3));
            editor.putStringSet("2", mySet2);
            editor.putString("3", "Streak The Lawn");
            editor.putString("4", "Go to Bodo's");
            editor.putString("5", "Go to Monticello");
            editor.putString("6", "Streak The Lawn");
            editor.putString("7", "Go to Bodo's");
            editor.putString("8", "Go to Monticello");
            editor.putString("9", "Go to Monticello");

            editor.commit();
        }
        else{

        }
        setContentView(R.layout.activity_list_main);
        ArrayList<customItem> customItems = customItem.getItems();
        customAdapter = new CustomItemAdapter(this, customItems);

        final ListView l = (ListView) findViewById(
                R.id.bucket_list_view);
        l.setAdapter(customAdapter);
        l.setItemsCanFocus(true);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListMainActivity.this, DisplayActivity.class);
                String message = Integer.toString(position);
                intent.putExtra("test", message);
                startActivity(intent);
//                Log.i("final", "Item " + position + ": " +
//                        customAdapter.getItem(position).getChecked() + ", " +
//                        customAdapter.getItem(position).getText());

            }
        });

        Log.i("final", "First Visible: " + l.getFirstVisiblePosition()
                + ", and Last: " + l.getLastVisiblePosition());

        //This is how to wait for the UI to be ready
//        l.post(new Runnable() {
//            public void run() {
//                Log.i("real", "Value of Last position: " + Integer.toString(l.getLastVisiblePosition()));
//                for (int i = 0; i < l.getLastVisiblePosition() - l.getFirstVisiblePosition(); i++) {
//                    Log.i("real", "Value of Last position: " + i + " **** " + checkedArraylist);
//                    View v = (View) l.getChildAt(i);
//                    if (v instanceof LinearLayout) {
//                        LinearLayout lin = (LinearLayout) v;
//                        for (int j = 0; j < lin.getChildCount(); j++) {
//                            View v2 = (View) lin.getChildAt(j);
//                            if (v2 instanceof CheckBox) {
//                                Log.i("real", "CheckBox at: " + i + ", Value : " + ((CheckBox) v2).isChecked());
//                                if (checkedArraylist.contains(i))
//                                    ((CheckBox) v2).setChecked(true);
//                            }
//                        }
//                    }
//                }
//            }
//        });

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
            String s = Integer.toString((int)view.getTag());
            Log.i("check!", s);
            //Get the previous settings for this item
            Set<String> stringSet = PreferenceManager.getDefaultSharedPreferences(this).getStringSet(s, new HashSet<String>());
            //setup the new
            String[] words = {stringSet.toArray()[2].toString(),
                    stringSet.toArray()[1].toString(),
                    "true"};
            //setup the editor
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();
            //initialize settings and put in shared
            Set<String> mySet2 = new HashSet<>(Arrays.asList(words));
            editor.putStringSet(s, mySet2);
            editor.commit();
        }
    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        ListView l = (ListView) findViewById(R.id.bucket_list_view);
//
//        for (int i = 0; i < l.getCount(); i++){
//            View v = (View)l.getChildAt(i);
//            if(v instanceof LinearLayout) {
//                LinearLayout lin = (LinearLayout) v;
//                if (lin.getChildCount() == 0) {
//                    Toast.makeText(this, "AHHHHHH No children", Toast.LENGTH_LONG).show();
//                }
//                for (int j = 0; j < lin.getChildCount(); j++) {
//                    View v2 = (View) lin.getChildAt(j);
//                    if (v2 instanceof CheckBox) {
//                        Log.i("real", "CheckBox !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!at: " + i + ", Value : "
//                                + ((CheckBox) v2).isChecked());
//                        savedInstanceState.putBoolean(Integer.toString(i), ((CheckBox) v2).isChecked());
//                        if ( ((CheckBox)v2).isChecked() ) {
//                            checkedArraylist.add(i);
//                            Log.i("real", "ADDING TO ARRAYLIST: " + i + ", arraylist: " + checkedArraylist);
//
//                        }
//                    } else if (v2 instanceof TextView) {
////                        Log.i("Save State", "TextView at: " + i +
////                        ", Value of : " + ((TextView)v2).getText());
//
//                    }
//                }
//
//            }
//
////            boolean b = customAdapter.getChecked(i);
////            String s = customAdapter.getTextString(i);
////            savedInstanceState.putBoolean(Integer.toString(i), b);
////            Log.i("Save State", "Item " + i + ": " + b + ", " + s);
//
////            View v = l.getChildAt(i);
////            CheckBox checkBox = (CheckBox) v.findViewById(R.id.completed_check);
////
//        }
////        savedInstanceState.putBoolean("IsCheckboxChecked", _myCheckbox.isChecked());
//    }
//
//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        ListView l = (ListView) findViewById(R.id.bucket_list_view);
////        if (l == null){
////            Log.i("final", "LIST IS DEAD ");
////        }
////        else{
////            Log.i("final", "LIST IS "+l.getFirstVisiblePosition() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
////
////        }
////        for (int i = 0; i < l.getCount(); i++) {
////
////            if (savedInstanceState.getBoolean(Integer.toString(i))) {
////                Log.i("final", "Item " + i + ": has a set key value pair, is type :  ");
////                Object v = l.getChildAt(i);
//////            Log.i("final", "Item " + i + ": ");
////                if (v == null){
////                    Log.i("final", "View IS DEAD ");
////                }
////                if (v instanceof LinearLayout) {
////                    Log.i("final", "**Item " + i + ": is a linear layout");
////
////                    LinearLayout lindog = (LinearLayout) v;
////                    for (int k = 0; k < lindog.getChildCount(); k++) {
////                        View v3 = (View) lindog.getChildAt(k);
////                        if (v3 instanceof CheckBox) {
////                            CheckBox checkBox = (CheckBox) v3;
////                            checkBox.setChecked(true);
////                        }
////
////                    }
////                    //                CheckBox box = (CheckBox) lindog.getChildAt(1);
////                    //                box.setChecked(true);
////                    Log.i("Save State", "*&&&&&&&&&&&&&&&^%$#$%^&*(*&^%$#@#$ " + i);
////                }
////            }
////        }
////        for (int i = 0; i < l.getCount(); i++){
////            View v = l.getChildAt(i);
////            CheckBox checkBox = (CheckBox) v.findViewById(R.id.completed_check);
////            if (savedInstanceState.getBoolean(Integer.toString(i))){
////                checkBox.setChecked(true);
////                checkBox.setEnabled(false);
////            }
////
////        }
////        _myCheckbox.setChecked(savedInstanceState.getBoolean("IsCheckboxChecked"));
//    }
}

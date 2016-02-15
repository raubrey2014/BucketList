package com.example.student.bucketlist2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Intent intent = getIntent();
        String message = intent.getStringExtra("test");
        TextView textView = new TextView(this);
        String str = "";
        if (message.equals("0")) {
            Set<String> title = sharedPref.getStringSet(message, new HashSet<String>());
            str = "UVa Bucket List Item " + message + ", Descr:"+ title.toArray()[2] +
                    ", Long Descr: " + title.toArray()[1] +"!";

        }
        else{
            String title = sharedPref.getString(message, "Default");
            str = "UVa Bucket List Item " + message + ", " + title +"!";
        }
        textView.setText(str);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }
}

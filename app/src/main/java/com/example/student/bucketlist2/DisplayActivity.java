package com.example.student.bucketlist2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Set;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("test");
        TextView textView1 = (TextView) findViewById(R.id.current_item_title);
        TextView textView2 = (TextView) findViewById(R.id.current_item_short);
        TextView textView3 = (TextView) findViewById(R.id.current_item_long);

        String str = "";
        Gson gson = new Gson();
        String json = sharedPref.getString(message, "default");
        bundleObject bundle = gson.fromJson(json, bundleObject.class);

        str = "UVa Bucket List Item " + message + "!";

        String shortD = bundle.getShortDescription();
        String longD = "Your goal: " + bundle.getLongDescription();
        boolean completed = bundle.getChecked();
        textView1.setText(str);
        textView2.setText(shortD);
        textView3.setText(longD);
        if (completed){
            TextView done = new TextView(this);
            done.setText("You have completed this task!");
            done.setTextColor(Color.GREEN);

            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content);
            linearLayout.addView(done);
        }
        else{
            TextView done = new TextView(this);
            done.setText("You have not completed this task! Click the Box below to mark as completed!");
            done.setTextColor(Color.RED);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content);
            linearLayout.addView(done);
            Button button = new Button(this);
            button.setText("Complete!");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPref.edit();

                    Gson gson = new Gson();
                    String json = sharedPref.getString(message, "default");
                    bundleObject bundle = gson.fromJson(json, bundleObject.class);
                    String jsonReturn = gson.toJson(new bundleObject(true, bundle.getShortDescription(), bundle.getLongDescription()));
                    editor.putString(message, jsonReturn);
                    editor.commit();
                }
            });
            linearLayout.addView(button);
        }
    }
}

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
        String message = intent.getStringExtra("test");
        TextView textView1 = (TextView) findViewById(R.id.current_item_title);
        TextView textView2 = (TextView) findViewById(R.id.current_item_short);
        TextView textView3 = (TextView) findViewById(R.id.current_item_long);

        String str = "";
        Set<String> title = sharedPref.getStringSet(message, new HashSet<String>());
        str = "UVa Bucket List Item " + message + "!";

        String shortD = title.toArray()[2].toString();
        String longD = "Your goal: " + title.toArray()[1].toString();
        boolean completed = Boolean.parseBoolean(title.toArray()[0].toString());
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
                    String[] words = {"",
                            "Run up and down the lawn without clothes, make lots of merry",
                            "false"};

                }
            });
            linearLayout.addView(button);
        }
    }
}

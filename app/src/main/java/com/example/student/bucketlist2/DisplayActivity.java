package com.example.student.bucketlist2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
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

        Gson gson = new Gson();
        String json = sharedPref.getString(message, "default");
        bundleObject bundle = gson.fromJson(json, bundleObject.class);


        String shortD = bundle.getShortDescription();
        String longD = bundle.getLongDescription();
        String diff = bundle.getDifficulty();
        boolean completed = bundle.getChecked();
        textView1.setText(shortD + ", Item: #" + message);
        textView2.setText(diff);
        if(diff.equals("Hard")){
            textView2.setTextColor(Color.RED);
        }
        else if(diff.equals("Medium")){
            textView2.setTextColor(Color.YELLOW);
        }
        else{
            textView2.setTextColor(Color.GREEN);
        }
        textView3.setText(longD);
        if (completed){
            TextView done = (TextView) findViewById(R.id.current_item_completed);
            done.setText("You have completed this task!");
            done.setTextColor(Color.GREEN);

        }
        else{
            TextView done = (TextView) findViewById(R.id.current_item_completed);
            done.setText("You have not completed this task! Click the Box below to mark as completed!");
            done.setTextColor(Color.RED);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content);
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
                    String jsonReturn = gson.toJson(new bundleObject(true, bundle.getShortDescription(), bundle.getLongDescription(), bundle.getDifficulty()));
                    editor.putString(message, jsonReturn);
                    editor.commit();
                    TextView done = (TextView) findViewById(R.id.current_item_completed);
                    done.setText("You have completed this task!");
                    done.setTextColor(Color.GREEN);
                    ((ViewManager)v.getParent()).removeView(v);

                }
            });
            linearLayout.addView(button);
        }
    }
}

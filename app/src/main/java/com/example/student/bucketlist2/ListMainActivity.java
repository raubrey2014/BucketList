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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
            Gson gson = new Gson();

            Log.i("final", "HERE IN NULL");
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();

            String json = gson.toJson(new bundleObject(false, "Streak The Lawn", "Run up and down the lawn without clothes, make lots of merry", "Easy"));
            editor.putString("0", json);
            json = gson.toJson(new bundleObject(false, "Go to Bodo's", "Try to get the first ticket at Bodo's", "Easy"));
            editor.putString("1", json);
            json = gson.toJson(new bundleObject(false, "Go to Monticello", "Visit T.J's home on top of the hill and learn more about the founder of our University", "Easy"));
            editor.putString("2", json);
            json = gson.toJson(new bundleObject(false, "Go on Boat Cruise", "Make a fool of yourself dancing on with strangers on a boat ride in D.C.", "Medium"));
            editor.putString("3", json);
            json = gson.toJson(new bundleObject(false, "Get Take it Away", "Sourdough, ham and turkey, cheddar, pickles, sprouts, sun-dried tomatoes, and of course house sauce. Enough said.", "Easy"));
            editor.putString("4", json);
            json = gson.toJson(new bundleObject(false, "Give Dean Groves a High Five", "The always energetic Dean Groves once broke the world record for the most high-fives in a few hours. Give him one more!", "Hard"));
            editor.putString("5", json);
            json = gson.toJson(new bundleObject(false, "Go to Lighting of the Lawn", "Take part in the iconic light show on Thomas Jefferson's famous Rotunda. Look out for quadcopters taking the best footage!", "Medium"));
            editor.putString("6", json);
            json = gson.toJson(new bundleObject(false, "Eat dinner in the Rotunda", "Suit and tie, dress and heels. Enjoy a slightly not wonderful meal put on by UVa Dining in the ever wonderful Rotunda.", "Hard"));
            editor.putString("7", json);
            json = gson.toJson(new bundleObject(false, "Go to West Range", "What used to be a hang out space for the original attendees of UVa is now a food stop. Make sure and try it out.", "Hard"));
            editor.putString("8", json);
            json = gson.toJson(new bundleObject(false, "Study in Clarke Library", "The entrance alone to this building will keep you from concentrating. Good luck!", "Easy"));
            editor.putString("9", json);
            json = gson.toJson(new bundleObject(false, "Take RELG 2650", "Theology, Ethics, and Medicine is a thought provoking class outside of the traditional path of UVa courses. Professor Childress is an eminent member of the ethics community.", "Hard"));
            editor.putString("10", json);
            json = gson.toJson(new bundleObject(false, "Throw Frisbee on the Lawn", "Whether it is with your friend or dog, throwing frisbee on the Lawn could not be traditional UVa and colleg. Enjoy!", "Easy"));
            editor.putString("11", json);
            json = gson.toJson(new bundleObject(false, "Go to Runk for Dinner", "Short lines and plenty of room makes for a good family atmosphere. Bring a friend who can play the piano for more memories.", "Medium"));
            editor.putString("12", json);
            json = gson.toJson(new bundleObject(false, "Go Steam Tunneling", "The danger is worth it, make sure and search around in the historic and mysterious steam tunnels stretching under our University", "Hard"));
            editor.putString("13", json);
            json = gson.toJson(new bundleObject(false, "Get a Boylan Burger", "Derby Days, Foreign Exchange, and others fill the menu at Boylan as their gormet burgers. Make sure and try it out!", "Medium"));
            editor.putString("14", json);
            json = gson.toJson(new bundleObject(false, "Go to a Concert Downtown", "Downtown is only a bus ride away, and Fridays After Five always had music, food, drink, and fun. Check it out!", "Medium"));
            editor.putString("15", json);
            json = gson.toJson(new bundleObject(false, "Go to a Pavilion on the Lawn", "Check out the Colonnade Club, or any of the other Pavilions on the Lawn to see the most honored professor housing!", "Easy"));
            editor.putString("16", json);
            json = gson.toJson(new bundleObject(false, "Go to JPJ for a basketball game", "Go see the Hoos crush the competition in John Paul Jones arena, while we are still good!", "Hard"));
            editor.putString("17", json);
            json = gson.toJson(new bundleObject(false, "Snowball Fight at Mad Bowl", "Gather some friends on a snow day and battle it out! See other groups snowboarding on the sides.", "Medium"));
            editor.putString("18", json);
            json = gson.toJson(new bundleObject(false, "Play an Intramural Sport", "Ultimate Frisbee, basketball, volleyball, and more are just some of the options available! Sign up today.", "Easy"));
            editor.putString("19", json);


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


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Bucket List", "List Activity Main onStart");
        final ListView l = (ListView) findViewById(
                R.id.bucket_list_view);
        l.post(new Runnable() {
            public void run() {
                Log.i("real", "Value of Last position: " + Integer.toString(l.getLastVisiblePosition()));
                for (int i = l.getFirstVisiblePosition(); i < l.getLastVisiblePosition() - l.getFirstVisiblePosition() + 1; i++) {
                    Log.i("real", "Value of i: " + i);

                    View v = (View) l.getChildAt(i);
                    if (v instanceof LinearLayout) {
                        LinearLayout lin = (LinearLayout) v;
                        for (int j = 0; j < l.getCount(); j++) {
                            View v2 = (View) lin.getChildAt(j);
                            if (v2 instanceof CheckBox) {
                                Log.i("real", "CheckBox at: " + i + ", Value : " + ((CheckBox) v2).isChecked());
                                Gson gson = new Gson();
                                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                                String json = sharedPref.getString(Integer.toString(i + l.getFirstVisiblePosition()), "default");
                                bundleObject bundle = gson.fromJson(json, bundleObject.class);
                                if (bundle.getChecked()) {
                                    Log.i("real", "CheckBox at: " + i + ", Value : " + ((CheckBox) v2).isChecked());

                                    ((CheckBox) v2).setChecked(true);
                                }
                            }
                        }
                    }
                }
            }
        });
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
//            view.setEnabled(false);
            String s = Integer.toString((int)view.getTag());
            Log.i("check!", s);
            //Get the previous settings for this item
            String stringSet = PreferenceManager.getDefaultSharedPreferences(this).getString(s, "");
            Gson gson = new Gson();
            bundleObject bundle = gson.fromJson(stringSet, bundleObject.class);
            //setup the new
            //setup the editor
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();
            //initialize settings and put in shared
            String jsonReturn = gson.toJson(new bundleObject(true, bundle.getShortDescription(), bundle.getLongDescription(),bundle.getDifficulty() ));

            editor.putString(s, jsonReturn);
            editor.commit();
        }
    }

}

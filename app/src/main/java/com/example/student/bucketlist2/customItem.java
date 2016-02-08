package com.example.student.bucketlist2;

import java.util.ArrayList;

public class customItem {
    public String text;
    public boolean checked;

    public customItem(String text, boolean checked){
        this.text = text;
        this.checked = checked;
    }

    public static ArrayList<customItem> getItems(){
        ArrayList<customItem> items = new ArrayList<customItem>();
        items.add(new customItem("Streak the Lawn", false));
        items.add(new customItem("Bodos", false));
        items.add(new customItem("Monticello", false));
        items.add(new customItem("Make a fool of yourself on Boat cruise", false));

        return items;
    }


}
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
        items.add(new customItem("Go Bodos", false));
        items.add(new customItem("Go Monticello", false));
        items.add(new customItem("Go on Boat Cruise", false));
        items.add(new customItem("Get Take it Away", false));
        items.add(new customItem("Give Dean Grove's a high five", false));
        items.add(new customItem("Go to Lighting of the Lawn", false));
        items.add(new customItem("Eat dinner in the Rotunda", false));
        items.add(new customItem("Go to West Range", false));
        items.add(new customItem("Study in Clarke Library", false));
        items.add(new customItem("Take RELG 2650", false));
        items.add(new customItem("Throw Frisbee on the Lawn", false));
        items.add(new customItem("Go to Runk for Dinner", false));
        items.add(new customItem("Go Steam Tunneling", false));
        items.add(new customItem("Get a Boylan Burger", false));
        items.add(new customItem("Go to a concert downtown", false));
        items.add(new customItem("Go to a Pavilion on the Lawn", false));
        items.add(new customItem("Go to JPJ for a basketball game", false));
        items.add(new customItem("Snowball Fight at Mad Bowl", false));
        items.add(new customItem("Play an Intramural Sport", false));



        return items;
    }

    public String getText() {
        return text;
    }

    public boolean getChecked(){
        return this.checked;
    }

    public void setChecked(boolean b){
        this.checked = b;

    }



}
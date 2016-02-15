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
        items.add(new customItem("Make a fool of yourself on Boat cruise", false));
        items.add(new customItem("Get Take it Away", false));
        items.add(new customItem("Give Dean Grove's a high five", false));
        items.add(new customItem("Go to Lighting of the Lawn", false));
        items.add(new customItem("Eat dinner in the Rotunda", false));
        items.add(new customItem("Go to West Range", false));
        items.add(new customItem("Study in Clarke", false));
//        items.add(new customItem("Get lost in Alderman Stacks", false));
//        items.add(new customItem("Break into the football stadium", false));
//        items.add(new customItem("Watch the Hoos at JPJ", false));
//        items.add(new customItem("Watch the marching band practice", false));
//        items.add(new customItem("Paint Beta Bridge", false));
//        items.add(new customItem("Volunteer for Madison House", false));
//        items.add(new customItem("Watch a rugby game at Mad Bowl", false));
//        items.add(new customItem("Go to graduation", false));
//        items.add(new customItem("Play basketball on the Dell courts", false));
//        items.add(new customItem("Go to the observatory at O'hill", false));


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
package com.example.student.bucketlist2;

/**
 * Created by Student on 2/15/2016.
 */
public class bundleObject {
    private boolean checked;
    private String shortDescription;
    private String longDescription;
    private String difficulty;

    public bundleObject(boolean b, String shortDescription, String longDescription, String difficulty){
        this.checked = b;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.difficulty = difficulty;
    }

    public boolean getChecked(){
        return this.checked;
    }

    public void setChecked(boolean b){
        this.checked = b;
    }

    public String getLongDescription(){
        return this.longDescription;
    }

    public String getShortDescription(){
        return this.shortDescription;
    }

    public String getDifficulty(){
        return this.difficulty;
    }

}

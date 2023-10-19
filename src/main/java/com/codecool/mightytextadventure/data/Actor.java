package com.codecool.mightytextadventure.data;

public class Actor {
    private String name;
    private int score;


    private boolean isItem;

    public Actor(String Name, String Description){
        this.Name = Name;
        this.Description = Description;
        isItem = false;
    }

    public Boolean getIsItem(){return isItem;}
    public void setItemIsTrue(){isItem=true;}

    public String getName(){
        return name;
    }
    public String getDescription(){
        return Description;

    }


}


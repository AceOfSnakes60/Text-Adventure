package com.codecool.mightytextadventure.data;

public class Actor {
    private String Name;
    private String Description;

    private boolean isItem;

    public Actor(String Name, String Description){
        this.Name = Name;
        this.Description = Description;
        isItem = false;
    }

    public Boolean getIsItem(){return isItem;}
    public void setItemIsTrue(){isItem=true;}

    public String getName(){
        return Name;
    }
    public String getDescription(){
        return Description;
    }


}


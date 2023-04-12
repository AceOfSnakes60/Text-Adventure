package com.codecool.mightytextadventure.data;

public class Actor {
    private String Name;
    private String Description;

    public Actor(String Name, String Description){
        this.Name = Name;
        this.Description = Description;
    }

    String getName(){
        return Name;
    }
    String getDescription(){
        return Description;
    }

    public void Open(){};
    public void Pick_up(){};
    public void Use(){};
    public void Combine(){};
    public void Look_at(){};
    public void Go_to(){};

}


package com.codecool.mightytextadventure.data;

public class Actor {
    private String name;
    private int score;

    public Actor(String name){
        this.name = name;
        this.score = 0;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void Open(){};
    public void Pick_up(){};
    public void Use(){};
    public void Combine(){};
    public void Look_at(){};
    public void Go_to(){};

}


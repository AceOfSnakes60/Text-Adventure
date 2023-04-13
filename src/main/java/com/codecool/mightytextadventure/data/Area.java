package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.logic.Player;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Area {
    private String name;
    private String description;
    private int[] exits;
    private ArrayList<Actor> actors;

    public Area(String name, String description){
        this.name = name;
        this.description = description;
        actors = new ArrayList<Actor>();
    }

    public void addActor(Actor actor){
        actors.add(actor);
    }
    public void removeActor(Actor actor){
        actors.remove(actor);
    }
    public Actor getActorByName(String name){
        for(Actor actor : actors) {
            if (Objects.equals(name, actor.getName())) {
                return actor;
            }
        }
        return null;
    }
    public ArrayList<Actor> getActors(){
        return actors;
    }
    public int getExit(int Direction, Player player){
        System.out.println("Parent");
        return -1;
    }

    public String getDescription(){
        return description;
    }
}

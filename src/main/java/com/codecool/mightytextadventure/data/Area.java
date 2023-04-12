package com.codecool.mightytextadventure.data;

import java.util.ArrayList;
import java.util.Map;

public class Area {
    private String name;
    private String description;
    private Map<String, Area> exits;
    private ArrayList<Actor> Actors;

    public Area(String Name, String Description, ArrayList<Actor> actors, Map<String, Area> exits){

        Actors = new ArrayList<Actor>();
    }

    //Constructor to easy solution
    public Area(String roomName){
        this.name = roomName;
    }

    public Area(String entrance, String description) {



    }

    public void addActor(Actor actor){
        Actors.add(actor);
    }
    public void removeActor(Actor actor){
        Actors.remove(actor);
    }

    public ArrayList<Actor> getActors(){
        return Actors;
    }

    public String getName() {
        return this.name;
    }
}

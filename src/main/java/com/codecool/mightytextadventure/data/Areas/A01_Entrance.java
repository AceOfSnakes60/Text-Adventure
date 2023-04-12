package com.codecool.mightytextadventure.data.Areas;

import com.codecool.mightytextadventure.data.Actor;
import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Item;

import java.util.ArrayList;
import java.util.Map;

public class A01_Entrance extends Area {
    private final int[] exits = {2, -1, -1, -1};

    public A01_Entrance(){
        super("Entrance","You stand south of the entrance to a mine. A stick is sticking in front of the opening.");
        addActor(new Item("stick", "A wooden stick. Very sticky."));
    }

    public int getExit(int Direction){
        System.out.println("Direction " + Direction);
        if(exits[Direction] == 2){
            System.out.println("Its too dark to proceed into the mine.");
            return -1;
        }
        return exits[Direction];
    }

}

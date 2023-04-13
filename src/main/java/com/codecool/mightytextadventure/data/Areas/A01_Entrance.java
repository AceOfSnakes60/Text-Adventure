package com.codecool.mightytextadventure.data.Areas;

import com.codecool.mightytextadventure.data.Actor;
import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Item;
import com.codecool.mightytextadventure.logic.Player;

import java.util.ArrayList;
import java.util.Map;

public class A01_Entrance extends Area {
    private final int[] exits = {1, -1, -1, -1};
    private boolean isDark = true;

    public A01_Entrance(){
        super("Entrance","You stand south of the entrance to a mine. A stick is sticking in front of the opening.");
        addActor(new Item("stick", "A wooden stick. Very sticky."));
    }

    public int getExit(int Direction, Player player){
        System.out.println("Direction " + Direction);
        if(exits[Direction] == 1){
            if(isDark) {
                if (player.getItemFromInventory("torch") != null) {
                    System.out.println("Using the torch to light the way you cautiously proceed forward.");
                    isDark=false;
                    return 1;
                }
                System.out.println("Its too dark to proceed into the mine.");
                return -1;
            }
        }
        return exits[Direction];
    }

}

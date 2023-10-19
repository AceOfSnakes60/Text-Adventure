package com.codecool.mightytextadventure.data.Areas;

import com.codecool.mightytextadventure.data.Actor;
import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Item;
import com.codecool.mightytextadventure.logic.Player;

public class A01_Tunnel extends Area {

    private int[] exits = {2, -1, 0, 3};
    private boolean isDoorLocked = true;
    public A01_Tunnel(){
        super("Tunnel", "The dark tunnel runs further north at a steep slope down. A door blocks your path east. You can hear rats scurrying beneath your feet.");
        addActor(new Actor("door", "Wooden door. It's rotten beyond belief."));
}
    public int getExit(int Direction, Player player){

        if(exits[Direction] == 3){
            if(isDoorLocked) {
                System.out.println("The wooden door blocks your way");
                return -1;
            }
        }
        return exits[Direction];
    }

    public void unlockDoor(){
        isDoorLocked=false;
    }
}

package com.codecool.mightytextadventure.data.Areas;

import com.codecool.mightytextadventure.data.Actor;
import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Item;
import com.codecool.mightytextadventure.logic.Player;

public class A02_Collapsed extends Area {
    private int[] exits = {4, -1, 1, -1};
    private boolean isPathBlocked = true;
    public A02_Collapsed() {
        super("Collapsed Tunnel", "You stand at a dead end. A pile of rocks block your path forward");
        addActor(new Actor("rocks", "A pile of rocks jammed in the corridor. They block your path forward."));
        addActor(new Item("pickaxe", "A rusty pickaxe that had its glory days long behind it."));
    }

    public int getExit(int Direction, Player player){
        return exits[Direction];
    }

    public void unblockPath(){
        isPathBlocked=false;
    }
}

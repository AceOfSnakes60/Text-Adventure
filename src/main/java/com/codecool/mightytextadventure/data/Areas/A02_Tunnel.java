package com.codecool.mightytextadventure.data.Areas;

import com.codecool.mightytextadventure.data.Area;

public class A02_Tunnel extends Area {

    private int[] exits = {0, 0, 1, 0};
    public A02_Tunnel(){
        super("Tunnel", "The dark tunnel runs further north at a steep slope down. You can hear rats scurrying beneath your feet.");
    }
}

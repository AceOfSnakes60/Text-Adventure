package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Actor;
import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;
import com.codecool.mightytextadventure.ui.MenuStart;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        MenuStart.welcomeScreen();
        MenuStart.startMenu();

        Display display = new Display();
        Input input = new Input();
        Area[] areas = loadAreas();

        display.printMessage("Starting Mighty Text Adventure!");

        Game game = new Game(areas, input, display);
        game.run();

        display.printMessage("Exiting from Mighty Text Adventure!");
    }

    private static Area[] loadAreas(){
        Area[] areas = new Area[7];

        areas[0] = new Area("Start room");
        areas[1] = new Area("Room 1");
        areas[2] = new Area("Room 2");
        areas[3] = new Area("Room 3");
        areas[4] = new Area("Room 4");
        areas[5] = new Area("Room 5");
        areas[6] = new Area("Room 6");

        System.out.println(areas[0].getName());

        return areas;
    }
}

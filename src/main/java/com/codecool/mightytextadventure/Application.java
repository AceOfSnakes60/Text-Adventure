package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);

        display.printMessage("Starting Mighty Text Adventure!");
        display.printMessage("Please provide your name:");
        String name =  scanner.nextLine();
        display.printMessage("Hello, " + name + "! Welcome to the game.");

        //TODO: modify below Area and Game - now infinity loop
        Area[] areas = loadAreas();

        Game game = new Game(areas, input, display);
        game.run();

        display.printMessage("Exiting from Mighty Text Adventure!");
    }

    private static Area[] loadAreas(){
        Area[] areas =   new Area[7];
        areas[0] = new Area("Start room");
        areas[1] = new Area("Room 1");
        areas[2] = new Area("Room 2");
        areas[3] = new Area("Room 3");
        areas[4] = new Area("Room 4");
        areas[5] = new Area("Room 5");
        areas[6] = new Area("Room 6");
        return areas;
    }
}

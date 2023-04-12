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
        String name = scanner.nextLine();
        display.printMessage("Hello, " + name + "! Welcome to the game.");

        //Initialize the game
        int score = 0;
        String command = "";
        Area[] areas = loadAreas();
        Area currentArea = areas[0];
        boolean hasDynamite = false;
        boolean hasEnteredMine = false;

        Scanner sc = new Scanner(System.in);

        //Print area information
        if (currentArea.getName().equals("Start room")) {
            display.printMessage("You have entered the mine.");
            hasEnteredMine = true;
            display.printMessage("The mine is too dark. Make a torch by combining Stick + cloth then light it with flint.");
        }

        while(true) {
            // Get player command
            System.out.print(">");
            command = sc.nextLine();

            // Deal with player input
            if(hasEnteredMine){
                if(command.equals("torch created")){
                    display.printMessage("Congratulations! Now you can search for dynamite.");
                    score += 10;
                    display.printMessage(String.valueOf(score));
                }
            }
        }

        //TODO: comment below Area and Game (3 lines) - to stop infinity loop
//        areas = loadAreas();
//
//        Game game = new Game(areas, input, display);
//        game.run();

//        display.printMessage("Exiting from Mighty Text Adventure!");
    }

    private static Area[] loadAreas() {
        Area[] areas = new Area[7];
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

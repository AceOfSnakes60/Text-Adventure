package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Actor;
import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.Scanner;

public class Game {
    private final Area[] areas;
    private final Input input;
    private final Display display;
    private Actor actor;
    Scanner scanner = new Scanner(System.in);

    public Game(Area[] areas, Input input, Display display) {
        this.areas = areas;
        this.input = input;
        this.display = display;
    }

    public void run() {

        display.printMessage("Please provide your name:");
        String name = scanner.nextLine();
        display.printMessage("Hello, " + name + "! Welcome to the game.");
        this.actor = new Actor(name);

        boolean isRunning = true;
        while (isRunning) {
            startArea1();
            startArea1();
            startArea1();
            startArea1();
            startArea1();
            startArea1();
            startArea1();
//            askIfRetry();

            isRunning = step();
        }
    }

    private boolean step() {
        display.printMessage("Steps");
        return true;
    }

    public void startArea1() {
        // Print area information
        Area firstArea = this.areas[0];
        display.printMessage("You have entered" + firstArea.getName());
        display.printMessage("This is the mine.");
        display.printMessage("The mine is too dark. What do you want to do?");
        display.printMessage("1. Create a torch by combining Stick + cloth then light it with flint");
        display.printMessage("2. Eat a sandwich");
        display.printMessage("0. Exit game.");

        // Get player command
        System.out.print(">");
        String command = this.input.getInputFromUser();

        // Deal with player input
        if (command.equals("1")) {
            display.printMessage("Congratulations! You have created a torch. Now you can search for dynamite.");
            int currentScore = actor.getScore();
            int newScore = currentScore + 10;
            actor.setScore(newScore);
            display.printMessage("Score: " + newScore);
        } else if (command.equals("2")) {
            display.printMessage("You eat your sandwich. It was delicious.");
            int currentScore = actor.getScore();
            int newScore = currentScore - 5;
            actor.setScore(newScore);
            display.printMessage("Score: " + newScore);
        } else if (command.equals("0")) {
            System.exit(0);
        } else {
            display.printMessage("Invalid command!");
        }
    }
}

package com.codecool.mightytextadventure.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuStart {
    static Scanner scanner = new Scanner(System.in);

    public static void welcomeScreen() throws FileNotFoundException {
        String filepath = "src/main/java/com/codecool/mightytextadventure/ui/welcomeImage.txt";
        TerminalManager.printFromFile(filepath);
    }

    public static void showMenu() {
        System.out.println("Choose option");
        System.out.println("1. Play Game");
        System.out.println("2. Exit program");

        TerminalManager.emptyLinesThree();
    }

    public static void startMenu() {
        boolean isRunning = true;

        TerminalManager.displayWelcomeScreen();

        while (isRunning) {

            showMenu();

            String choosedOption = scanner.nextLine();

            switch (choosedOption) {
                case "1":
                    isRunning = false;
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    TerminalManager.clearScreen();
                    System.out.println("\nWrong input\n");
            }
        }
        TerminalManager.clearScreen();
    }
}

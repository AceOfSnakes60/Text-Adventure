package com.codecool.mightytextadventure.ui;

import java.util.Scanner;

public class TerminalManager {

    private static Scanner scanner = new Scanner(System.in);


    public static void emptyLinesThree() {
        System.out.println("\n\n");
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("\n-----------------------------");
        System.out.println("| Press any key and enter to continue |");
        System.out.println("-----------------------------");
        scanner.nextLine();
    }

    public static void displayWelcomeScreen() {
        System.out.println("Produced by: ");
        System.out.println("Piotr Gutkowski");
        System.out.println("Magdalena Huget");
        System.out.println("Piotr Maślanka");
        System.out.println("Marcin Nikel\n");
        pressAnyKeyToContinue();
        clearScreen();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

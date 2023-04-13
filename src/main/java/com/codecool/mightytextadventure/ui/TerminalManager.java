package com.codecool.mightytextadventure.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TerminalManager {

    public static Scanner scanner = new Scanner(System.in);


    public static void emptyLinesThree() {
        System.out.println("\n\n");
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("\n---------------------------------------");
        System.out.println("| Press any key and enter to continue |");
        System.out.println("---------------------------------------");
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



    public static void printFromFile(String filepath) throws FileNotFoundException {
        TerminalManager.clearScreen();

        Scanner input = new Scanner(new File(filepath));

        while (input.hasNextLine()) {
            System.out.print(Color.CYAN);
            System.out.println(input.nextLine());
        }
        System.out.println(Color.RESET);
    }
}

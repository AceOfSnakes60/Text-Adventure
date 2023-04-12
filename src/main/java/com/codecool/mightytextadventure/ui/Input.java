package com.codecool.mightytextadventure.ui;

import java.util.Scanner;

public class Input {

    public String getInputFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String inputProvidedByUser = scanner.nextLine();
        return inputProvidedByUser;
    }

}

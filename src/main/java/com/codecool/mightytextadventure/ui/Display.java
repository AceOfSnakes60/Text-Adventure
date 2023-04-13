package com.codecool.mightytextadventure.ui;

public class Display {

    public void printMessage(String message) {
        System.out.println(message);
    }
    public void printHelp(){
        System.out.println("Commands:\n" +
                "Look\n" +
                "\n" +
                "Go [Direction]\n" +
                "\n" +
                "examine [Actor]\n" +
                "Take [Item]\n" +
                "Use [Actor]\n" +
                "Use [Item] on [Actor]\n" +
                "Combine [Item] with [Item]\n" +
                "\n" +
                "Inventory\n" +
                "\n" +
                "Help\n" +
                "\n" +
                "Exit\n");
    }
}

package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Areas.A00_Entrance;
import com.codecool.mightytextadventure.data.Areas.A01_Tunnel;
import com.codecool.mightytextadventure.data.Areas.A02_Collapsed;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.logic.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

public class Application {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        Player player = new Player();

        display.printMessage("Starting Mighty Text Adventure!");

        Area[] areas = loadAreas();

        Game game = new Game(areas, input, display, player);
        game.run();

        display.printMessage("Exiting from Mighty Text Adventure!");
    }

    private static Area[] loadAreas(){
        Area[] areas =   new Area[7];
        areas[0] = new A00_Entrance();
        areas[1] = new A01_Tunnel();
        areas[2] = new A02_Collapsed();
        return areas;
    }
}

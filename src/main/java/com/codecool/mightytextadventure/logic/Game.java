package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Actor;
import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Enums.Directions;
import com.codecool.mightytextadventure.data.Item;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Game {
    private final Area[] areas;
    private final Input input;
    private final Display display;
    private final Player player;
    private int currentArea = 0;

    public Game(Area[] areas, Input input, Display display, Player player) {
        this.areas = areas;
        this.input = input;
        this.display = display;
        this.player = player;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            isRunning = step();
        }
    }

    private boolean step() {
        display.printMessage(areas[currentArea].getDescription());
        String[] userInput = input.getInputFromUser();
        runCommand(userInput);
        display.printMessage("Steps");
        return true;
    }
    private void goDirection(String Direction){

        Directions eDirection = null;
        if(Objects.equals(Direction, "north") || Objects.equals(Direction, "n")){
            eDirection = Directions.NORTH;
        }
        else if(Objects.equals(Direction, "west") || Objects.equals(Direction, "w")){
            eDirection = Directions.WEST;
        }
        else if(Objects.equals(Direction, "south") || Objects.equals(Direction, "s")){
            eDirection = Directions.SOUTH;
        }
        else if(Objects.equals(Direction, "east") || Objects.equals(Direction, "e")){
            eDirection = Directions.EAST;
        }
        else{
            return;
        }

            int moveTo = areas[currentArea].getExit(eDirection.ordinal());
        if(moveTo==-1||areas[moveTo]==null){
            display.printMessage("Can't go this way");
            return;
        }
        currentArea = moveTo;
    }
    private void runCommand(String[] command){
        display.printMessage(Arrays.toString(command));
        switch(command.length){
            case 1:
                switch(command[0]){
                    case "look":
                        display.printMessage(areas[currentArea].getDescription());
                        break;
                    case "inventory":
                        display.printMessage(player.displayInventory());
                    case "help":
                    case "exit":
                }
                break;
            case 2:
                switch(command[0]){
                    case "go":
                        goDirection(command[1]);
                        break;
                    case "examine":
                        examineTarget(command[1]);
                        break;
                    case "take":
                        takeTarget(command[1]);
                    case "use":
                }
                break;
            case 3:
                switch(command[0]){
                    case "use":
                    case "combine":
                        combineItems(command[1], command[2]);
                }
                break;

        }
    }

    private void examineTarget(String target){
        Actor actor = player.getItemFromInventory(target);
        if(actor != null){
            display.printMessage(actor.getDescription());
            return;
        }
        actor = areas[currentArea].getActorByName(target);
        if(actor!=null){
            display.printMessage(actor.getDescription());
            return;
        }
        display.printMessage("You are looking at nothing.");
    }
    private void takeTarget(String target){
        Actor actor = areas[currentArea].getActorByName(target);
        if(actor!=null){
            if(actor.getIsItem()){
                display.printMessage("You stuffed the "+actor.getName()+" inside your unusually large pocket.");
                player.addToInventory((Item) actor);
                areas[currentArea].removeActor(actor);
                return;
            }
            display.printMessage("It's nailed down");
            return;
        }
        display.printMessage("What you're trying to pick doesn't exist.");
    }
    private void combineItems(String item1, String item2){
        if(item1=="stick" && item2=="cloth"||item1=="cloth" && item2=="stick"){

        }
    }

}

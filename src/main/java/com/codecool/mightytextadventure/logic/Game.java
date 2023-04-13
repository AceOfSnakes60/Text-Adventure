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

            int moveTo = areas[currentArea].getExit(eDirection.ordinal(), this.player);
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
                        break;
                    case "help":
                        display.printHelp();
                        break;
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
                        break;
                    case "use":
                        useItem(command[1]);
                        break;
                }
                break;
            case 3:
                switch(command[0]){
                    case "use":
                        useItemOn(command[1], command[2]);
                        break;
                    case "combine":
                        combineItems(command[1], command[2]);
                        break;
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
    private void combineItems(String command1, String command2){
        Item item1 = player.getItemFromInventory(command1);
        Item item2 = player.getItemFromInventory(command2);
        if(item1==null||item2==null){
            display.printMessage("You don't have the items!");
            return;
        }
        //Write specific COMBINE logic here


        if(item1.getName()=="stick" && item2.getName()=="cloth"||item1.getName()=="cloth" && item2.getName()=="stick"){
            player.removeFromInventory(item1.getName());
            player.removeFromInventory(item2.getName());
            display.printMessage("By combing a stick and a cloth you make a torch.");
            player.addToInventory(new Item("torch", "Wooden stick with a fire on its end."));
            return;
        }

        //---------------------------------
        display.printMessage("You can't make anything out of this");
    }


    private void useItem(String itemName){
        Item item = player.getItemFromInventory(itemName);
        if(item==null){
            display.printMessage("You don't have the item!");
            return;
        }
        //Write specific USE ITEM logic here

        //---------------------------------
        display.printMessage("You cant use a "+itemName+". It's nonsense.");

    }
    private void useItemOn(String itemName, String targetName){
        Item item = player.getItemFromInventory(itemName);
        Actor target = areas[currentArea].getActorByName(targetName);
        if(item==null){
            display.printMessage("You don't have the item!");
            return;
        }
        if(target==null){
            display.printMessage("You have nothing to use the "+ itemName + " on!");
        }
        //Write specific USE ITEM ON logic here
        if(Objects.equals(itemName, "pickaxe") && Objects.equals(targetName, "rocks")){
            display.printMessage("After a while of back-breaking labour you realize it would take ages to clear this tunnel. You need something stronger.");
            return;
        }
        if(Objects.equals(itemName, "pickaxe") && Objects.equals(targetName, "door")){
            areas[currentArea].removeActor(target);
            player.removeFromInventory(itemName);
            display.printMessage("After a little effort the door breaks apart into tiny splinters. Your rusty pickaxe also turns into dust.");
            return;
        }
        if(Objects.equals(itemName, "dynamite") && Objects.equals(targetName, "rocks")){
            areas[currentArea].removeActor(target);
            player.removeFromInventory(itemName);
            display.printMessage("You blow up the pile of rocks. Dust fills the air making its way into your lungs causing a violent cough. \nNonetheless the path is open.");
            return;
        }
        //---------------------------------
        display.printMessage("You cant use "+ itemName +" on "+targetName+". It's madness!");
    }

}

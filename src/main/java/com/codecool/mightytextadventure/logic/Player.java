
package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String Name;
    private final ArrayList<Item> inventory;

    public Player(){
        inventory = new ArrayList<Item>();
        addToInventory(new Item("cloth", "A piece of oil-stained cloth."));
    }
    private Item findItem(String name){
        for(Item item: inventory){
            if(Objects.equals(item.getName(), name)){
                return item;
            }
        }
        return null;
    }
    public Item getItemFromInventory(String name){
        return findItem(name);
    }
    public void addToInventory(Item item){
        inventory.add(item);
    }
    public void removeFromInventory(String name){
        Item item = findItem(name);
        if(item!=null){
            inventory.remove(findItem(name));
        }

    }

    public String displayInventory(){
        if(inventory.isEmpty()){
            return "Your Inventory is empty";
        }

        String message = "Inventory:\n";
        int count = 1;
        for(Item item: inventory){
            message += count + ": " + item.getName() + "\n";
            count++;
        }
        return message;
    }

}


package com.marin.saul.a02_adventure.model;

import java.util.LinkedList;

/**
 * Created by usuario on 20/12/2016.
 */
public class Inventory {
    private LinkedList<Item> inventory = new LinkedList<>();

    public Inventory(){

    }

    public void print(){
        System.out.println("------------\nMochila\n------------");
        for (Item item: inventory){
            System.out.println(item.getName()+": "+item.getDescription());
        }
    }

    public void add(Item item){
        inventory.add(item);
    }
    public LinkedList<Item> getItems(){
        return inventory;
    }




}

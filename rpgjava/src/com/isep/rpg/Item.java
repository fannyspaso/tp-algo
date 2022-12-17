package com.isep.rpg;

public abstract class Item{
    private String name;


    public Item(String name, int i) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

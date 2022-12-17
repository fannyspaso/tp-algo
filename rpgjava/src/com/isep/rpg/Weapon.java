package com.isep.rpg;

public class Weapon extends Item{
    String name;
    int pvarme;

    public Weapon(String name, int pvarme) {
        super(name, 10);
        this.name = name;
        this.pvarme = pvarme;
    }

    public int getDps(){
        return this.pvarme;
    }
}

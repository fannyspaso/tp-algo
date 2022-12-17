package com.isep.rpg;
import java.util.Random;

public abstract class Enemy extends Combatant {

    private String name;
    public Enemy(String n, int hp) {
        super(n, 50, 10,10,0,0,0,0,0,0,0,0);
        this.name = n;
    }

    // Accesseurs GET
    public String getName() {
        return this.name;
    }

}
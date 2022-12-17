package com.isep.rpg;

public class Dragon extends Enemy {

    private String name;
    private Weapon weapon = new Weapon("boule de feu", 6);


    public Dragon(String n, int hp) {
        super(n, hp);
        this.name = n;
        this.weapon= weapon;
    }

    @Override
    public int getDamage() {
        return this.weapon.getDps();
    }

    public void fight(Combatant combatant) {
        combatant.Pertepv(this.weapon.getDps());
    }

}

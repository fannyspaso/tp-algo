package com.isep.rpg;

public abstract class Hero extends Combatant {

    // Creation du sac d'objet
    private Item[] addItemSacHero = new Item[5];

    public Hero(String n, int hp, int mana, int manaCost, int spellEfficiency, int damage, int potionEfficiency, int foodEfficiency, int numFood, int numPotions, int numArrows) {
        super(n, 50,10,10,4,4,5,2,2,2,2,2);

        // Ajout d'objet pour regen les pv
        this.addItemSacHero(new Food(), 0);
        this.addItemSacHero(new Food(), 1);
        this.addItemSacHero(new Food(), 2);
    }

    public void addItemSacHero(Item i, int placement) {
        this.addItemSacHero[placement] = i;
    }
}

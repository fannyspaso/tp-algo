package com.isep.rpg;

public abstract class SpellCaster extends Hero{

    public SpellCaster(String n, int hp, int mana) {
        super(n, 50,2,4,4,5,2,2,2,2,0);

        // Ajout d'objet pour regen les pv
        super.addItemSacHero(new Potion(), 3);
        super.addItemSacHero(new Potion(), 4);

    }
}

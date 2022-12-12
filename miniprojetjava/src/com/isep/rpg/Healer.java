package com.isep.rpg;

public class Healer extends SpellCaster{

    private Weapon weapon = new Weapon("sort qui régénère", 5);

    public Healer(String n, int hp, int mana) {
        super(n, hp, 10);
        this.name = n;
        this.mana = 10;
    }

    @Override
    public void Pertepv1(int damage) {

    }

    @Override
    public void fight(Combatant combatant) {
        combatant.Pertepv(this.weapon.getDps());
    }

    @Override
    public int getDamage() {
        return this.weapon.getDps();}

    public void addMana(int n)
    {
        this.mana += n;
    }

    @Override
    public int getMana()
    {
        return this.mana;
    }
}

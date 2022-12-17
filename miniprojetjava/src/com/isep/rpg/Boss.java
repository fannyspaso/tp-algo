package com.isep.rpg;

public class Boss extends Combatant {

    String name;
    private Weapon weapon = new Weapon("coup de poing !", 9);
    private int PointsVie;

    public Boss(String name, int pvv) {
        super("Boss final", 60,10, 6,0,0,9,0,0,0,0,0);
        this.name = name;
        this.PointsVie = pvv;
    }


    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.weapon.getDps();
    }


    @Override
    public void fight(Combatant combatant) {
        combatant.Pertepv(this.weapon.getDps());
    }


    public void win(int PointsVie) {
        this.PointsVie = 6 + PointsVie;
    }
}



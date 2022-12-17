package com.isep.rpg;

public class Mage extends SpellCaster {

    private String name;
    private int mana;
    private int damage;
    private int potionEfficiency;
    private int foodEfficiency;
    private int numPotions;
    private int numFood;
    private int manaCost; // Pour les sorceleurs
    private int spellEfficiency; // Pour les sorceleurs
    private Weapon weapon = new Weapon("magie", 9);
    private Weapon potion = new Weapon("elexir mage", 9);
    private Weapon food = new Weapon("bonbon mage", 9);


    public Mage(String n, int hp, int mana, int manaCost, int spellEfficiency,int damage, int potionEfficiency, int foodEfficiency, int numFood, int numPotions) {
        super(n, 50, 10);
        this.name = n;
        this.mana = 2;
        this.damage = damage;
        this.potion= potion;
        this.food = food;
        this.potionEfficiency = potionEfficiency;
        this.foodEfficiency = foodEfficiency;
        this.numPotions = numPotions;
        this.numFood = numFood;
        this.manaCost = manaCost;
        this.spellEfficiency = spellEfficiency;
    }

    // Méthode pour diminuer le coût en mana pour les sorts du personnage (pour les sorceleurs)
    public void decreaseManaCost() {
        this.manaCost--;
    }

    // Méthode pour augmenter l'efficacité des sorts du personnage (pour les sorceleurs)
    public void increaseSpellEfficiency() {
        this.spellEfficiency++;
    }

    public int getMana() {
        return this.mana;
    }

    public int getDamage() {
        return this.weapon.getDps();
    }

    @Override
    public void fight(Combatant combatant){
        combatant.Pertepv(this.weapon.getDps());

    }

    public void addMana(int n){
        this.mana += n;
    }

    // Méthode pour augmenter les dégâts causés par le personnage
    public void increaseDamage() {
        this.pvarme =  2*pvarme;
    }

}

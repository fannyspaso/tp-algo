package com.isep.rpg;

public class Warrior extends Hero{

    private String name;
    private int hp;
    private int damage;
    private int potionEfficiency;
    private int foodEfficiency;
    private int numFrappe;
    private int numPotions;
    private int numFood;
    private Weapon potion = new Weapon("elexir warrior", 9);
    private Weapon food = new Weapon("bonbon warrior", 9);
    private Weapon weapon = new Weapon("frappe au corps à corps", 10);

    public Warrior(String n, int hp, int numFrappe, int damage, int potionEfficiency, int foodEfficiency, int numPotions, int numFood){
        super(n, hp,5,5,4,5,4,4,2,2,0);
        this.name = n;
        this.numFrappe = numFrappe;
        this.potion= potion;
        this.food = food;
        this.damage = damage;
        this.potionEfficiency = potionEfficiency;
        this.foodEfficiency = foodEfficiency;
        this.numPotions = numPotions;
        this.numFood = numFood;
    }

    // Méthode pour augmenter les dégâts causés par le personnage
    public void increaseDamage() {
        this.pvarme =  2*pvarme;
    }

    // Méthode pour augmenter l'efficacité des potions du personnage
    public void increasePotionEfficiency() {
        this.potionEfficiency++;
    }

    // Méthode pour augmenter l'efficacité de la nourriture du personnage
    public void increaseFoodEfficiency() {
        this.foodEfficiency++;
    }

    // Méthode pour augmenter le nombre de potions du personnage
    public void increaseNumPotions() {
        this.numPotions++;
    }

    // Méthode pour augmenter le nombre de nourriture du personnage
    public void increaseNumFood() {
        this.numFood++;
    }

    // Méthode pour augmenter le nombre de flèches du personnage (pour le Hunter)
    public void increasenumFrappe() {
        this.numFrappe++;
    }

    public int getDamage() {
        return this.weapon.getDps();
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void fight(Combatant combatant){
        combatant.Pertepv(this.weapon.getDps());
    }

}

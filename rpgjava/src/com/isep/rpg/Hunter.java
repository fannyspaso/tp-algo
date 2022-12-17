package com.isep.rpg;

public class Hunter extends Hero{
    private String name;
    private int hp;
    private int damage;
    private int potionEfficiency;
    private int foodEfficiency;
    private int numArrows;
    private int numPotions;
    private int numFood;
    private Weapon weapon = new Weapon("tire des flèches", 9);
    private Weapon potion = new Weapon("elexir hunter", 9);
    private Weapon food = new Weapon("bonbon hunter", 9);

    public Hunter(String n, int hp, int numArrows, int damage, int potionEfficiency, int foodEfficiency, int numPotions, int numFood) {
        super(n, 50,10,5,4,4,2,2,2,2, 2);
        this.name = n;
        this.hp = 50;
        this.potion= potion;
        this.food = food;
        this.numArrows = numArrows;
        this.damage = damage;
        this.potionEfficiency = potionEfficiency;
        this.foodEfficiency = foodEfficiency;
        this.numPotions = numPotions;
        this.numFood = numFood;

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
    public void increaseNumArrows() {
        numArrows= numArrows+ 2;
    }

    public int getDamage() {
        return this.weapon.getDps();
    }

    public int getNumArrows(){
        return this.numArrows;
    }

    // Méthode pour augmenter les dégâts causés par le personnage
    public void increaseDamage() {
        this.pvarme =  2*pvarme;
    }

    public int getNumPotions(){
        return this.numPotions;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void fight(Combatant combatant) {
    }
}

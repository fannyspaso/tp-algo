package com.isep.rpg;

public class Healer extends SpellCaster{

    private String name;
    private int hp;
    private int mana;
    private int damage;
    private int pointsvie;
    private int potionEfficiency;
    private int foodEfficiency;
    private int numPotions;
    private int numFood;
    private int manaCost; // Pour les sorceleurs
    private int spellEfficiency; // Pour les sorceleurs
    private Weapon weapon = new Weapon("sort qui régénère", 9);
    private Weapon potion = new Weapon("elexir", 9);
    private Weapon food = new Weapon("bonbon", 9);


    public Healer(String n, int hp, int mana, int manaCost, int spellEfficiency,int damage, int potionEfficiency, int foodEfficiency, int numFood, int numPotions) {
        super(n, 50, 2);
        this.name = n;
        this.hp = 50;
        this.potion= potion;
        this.food = food;
        this.weapon= weapon;
        this.pointsvie = hp;
        this.mana = 10;
        this.damage = damage;
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

    @Override
    public int getDamage() {
        return this.weapon.getDps();
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    // Méthode pour augmenter les dégâts causés par le personnage
    public void increaseDamage() {
        this.pvarme =  2*pvarme;
    }

    public int getPointsvie() {
        return this.pointsvie;
    }

    @Override
    public void fight(Combatant combatant){
    }


    public void addMana(int n) {
        this.mana += n;
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

}

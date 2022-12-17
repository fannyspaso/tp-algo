package com.isep.rpg;

public abstract class Combatant {

    String name;
    private int pointsvie;
    int mana;
    int pvarme;
    private int damage;
    private int potionEfficiency;
    private int foodEfficiency;
    private int numFrappe;
    private int numPotions;
    private int numFood;
    private int numArrows;


    public Combatant(String n, int hp, int mana, int pvarme, int manaCost, int spellEfficiency,int damage, int NumArrows, int potionEfficiency, int foodEfficiency, int numFood, int numPotions) {
        this.name = n;
        this.pointsvie = hp;
        this.mana = mana;
        this.pvarme = pvarme;
        this.numFrappe = numFrappe;
        this.damage = damage;
        this.potionEfficiency = potionEfficiency;
        this.foodEfficiency = foodEfficiency;
        this.numPotions = numPotions;
        this.numFood = numFood;
        this.numArrows = numArrows;
    }


    // Classe abstraite
    public abstract void fight(Combatant combatant);
    public abstract int getDamage();

    // Méthode pour augmenter les dégâts causés par le personnage
    public void increaseDamage() {
        this.pvarme =  2*pvarme;
    }

    // Méthode pour augmenter l'efficacité des potions du personnage
    public void increasePotionEfficiency() {
        this.potionEfficiency = potionEfficiency + 1;
    }

    // Méthode pour augmenter l'efficacité de la nourriture du personnage
    public void increaseFoodEfficiency() {
        this.foodEfficiency = foodEfficiency+ 1;
    }

    // Méthode pour augmenter le nombre de potions du personnage
    public void increaseNumPotions() {
        this.numPotions = numPotions + 1;
    }

    // Méthode pour augmenter le nombre de nourriture du personnage
    public void increaseNumFood() {
        this.numFood = numFood + 1;
    }

    // Méthode pour augmenter le nombre de flèches du personnage (pour le Hunter)
    public void increaseNumArrows() {
        this.numArrows = numArrows + 2;
    }

    public void diminuerMana(){
        this.mana = mana -2;
    }

    public void increasePointsVie() {
        this.pointsvie = pointsvie+2;
    }

    // Accesseurs GET
    public String getName() {
        return this.name;
    }

    public int getPointsvie() {
        return this.pointsvie;
    }

    public int getMana() {
        return this.mana;
    }

    public int getFoodEfficiency() {
        return foodEfficiency;
    }

    public int getNumFood() {
        return numFood;
    }

    public int getNumPotions() {
        return numPotions;
    }

    public int getPotionEfficiency(){
        return potionEfficiency;
    }

    public int getNumArrows(){
        return this.numArrows;
    }

    public int getPvarme(){
        return this.pvarme;
    }

    public void Pertepv(int pvarme) {
        this.pointsvie = this.pointsvie - pvarme;
    }

    public void pointsVieLembas(int pointsvie) {
        this.pointsvie = 2 + pointsvie;
    }

    public void pointsVieNourri(int pointsvie) {
        this.pointsvie = 4 + pointsvie;
    }

    public void addMana(int n){
        this.mana =+ 3;
    }

    public void def(int pointsvie) {
        this.pointsvie = 2 + pointsvie;
    }


}

/*package com.isep.java.isep.jfx;

import com.isep.rpg.*;

import java.util.*;

public class ApplicationController {

    public class Game {
        boolean gameOver = false;
        int manche = 1;

        Combatant[] liste_heros;
        Combatant[] liste_ennemis;
        Combatant[] liste_boss = new Combatant[1];

        public Game() {

            this.chooseNbHeros();
            this.createAllHeros();
            //this.Testavecheros();
            this.Créationennemis();


            while (!this.gameOver) {
                this.affichePlateau();
                System.out.println("");


                Combatant[] liste_combatants = new Combatant[this.liste_heros.length + this.liste_ennemis.length];
                System.arraycopy(this.liste_heros, 0, liste_combatants, 0, this.liste_heros.length);
                System.arraycopy(this.liste_ennemis, 0, liste_combatants, this.liste_heros.length, this.liste_ennemis.length);
                //System.out.println("Concatenated Array : " + Arrays.toString(liste_combatants));
                List<Combatant> list = Arrays.asList(liste_combatants);
                Collections.shuffle(list);
                list.toArray(liste_combatants);
                //System.out.println("Random Array : " + Arrays.toString(liste_combatants));



                for (Combatant fighter : liste_combatants) {
                    List<Combatant> liste = Arrays.asList(this.liste_ennemis);
                    if (liste.contains(fighter)) {


                        Random r = new Random ();
                        int randomNumber = r.nextInt(this.liste_heros.length);
                        Combatant ennemi = liste_heros[randomNumber];
                        fighter.fight(ennemi);
                        System.out.println(fighter.getName() + " attaque " + ennemi.getName() + "  les points de pv perdus sont : " + fighter.getDamage());

                        if (ennemi.getPointsvie() <= 0) {
                            this.liste_heros = this.removeElement(this.liste_heros, randomNumber);
                            System.out.println(ennemi.getName() + " est mort !");
                        }

                    }

                    else {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Choisissez le type d'action pour votre héros : 1= attaquer, 2= défendre, 3= utiliser un consommable");
                        int type_action = scanner.nextInt();
                        Random r = new Random();
                        int randomNumber = r.nextInt(this.liste_ennemis.length);
                        // recuperation de la cible
                        Combatant ennemiis = liste_ennemis[randomNumber];
                        //Combatant cible = liste_heros[this.randomNumber];

                        if (type_action == 1) {
                            System.out.println("Le combatant " + fighter.getName() + " attaque l'ennemi : " + ennemiis.getName());
                            fighter.fight(ennemiis);

                        } else if (type_action == 2) {
                            System.out.println( fighter.getName() + "se protège de " + ennemiis.getName()+ " et il perd 3 point de vie ");
                            fighter.def(fighter.getPointsvie());

                        } else if (type_action == 3) {
                            System.out.println("J'utilise un consommable");
                            //private ArrayList<Consumable> liste_consommable = new ArrayList<Consumable>();
                            // public void useConsommable(Combatant Gentil, Combatant Mechant)

                            Scanner scanner1 = new Scanner(System.in);
                            System.out.println("Choisissez le consommable : 1= Manger du lembas, 2= Autre nourriture, 3=boire une potion pour restaurer la mana des lanceurs de sorts");
                            int conso = scanner1.nextInt();

                            if (conso == 1) {
                                fighter.win(fighter.getPointsvie());
                                System.out.print("Grace au lembas, je gagne des points de vie !!");
                            } else if (conso == 2) {
                                fighter.consu(fighter.getPointsvie());
                                System.out.print("Grace à la nourriture,je gagne des points de vie !! ");

                            }
                            //uniquement pour Mage et Healer
                            else if (conso == 3) {
                                fighter.consu(fighter.getPointsvie());
                                System.out.print("Grace à la potion,la mana du spellcaster est restaurée : " + fighter.getName() + " (" + fighter.getPointsvie() + " ) ");

                            } else {
                                System.out.println("Tapez un autre numéro ");
                            }

                            fighter.fight(fighter);
                            System.out.println(fighter.getName() + " attaque : " + ennemiis.getName() + " | Degats = " + fighter.getDamage());

                            this.liste_ennemis = this.removeElement(this.liste_ennemis, randomNumber);
                            System.out.println(getClassName(ennemiis.getClass()) + ennemiis.getName() + " est mort !");
                        }
                    }
                    if (this.liste_ennemis.length == 0 | this.liste_heros.length == 0) {
                        this.gameOver = true;
                        System.out.println("Un des deux camps n'a plus de combatants ... il a perdu le combat");
                        break;
                    }

                }

                if (manche == 5 ) {

                    //this.affichePlateau();
                    //this.gameOver = true;
                    liste_boss[0] = new Boss("Boss final !!", 100);

                    System.out.println("\nLes survivants vont combattre le boss");

               while(this.liste_heros.length != 0 | liste_boss.length != 0 ){
                   System.out.println(liste_boss[0].getName());
                   System.out.println(fighter.getName() + " attaque : " + BOSS.getName() + " | Degats = " + fighter.getDamage());

                   // Si l'attakant est mort
                   if (BOSS.getHealthPoint() <= 0) {
                       this.liste_boss = this.removeElement1(this.liste_boss);
                       System.out.println(BOSS.getName() + " est mort !");
                   }
              /*  }
                this.manche++;

            }
            this.manche++;
        }

*/
/*

        public Combatant[] removeElement( Combatant [] arr, int index ){
            Combatant[] arrDestination = new Combatant[arr.length - 1];
            int remainingElements = arr.length - ( index + 1 );
            System.arraycopy(arr, 0, arrDestination, 0, index);
            System.arraycopy(arr, index + 1, arrDestination, index, remainingElements);
            //System.out.println("Elements -- "  + Arrays.toString());
            return arrDestination;
        }





        public void Testavecheros() {
            this.liste_heros = new Combatant[4];
            this.liste_ennemis = new Combatant[4];
            this.liste_heros[0] = new Hunter("hunter", 50);
            this.liste_heros[1] = new Warrior("warrior", 50);
            this.liste_heros[2] = new Healer("healer", 50, 10);
            this.liste_heros[3] = new Mage("mage", 50, 10);
        }


        public void chooseNbHeros() {
            // Choix du nombre de Heros
            int nbCombatant = SafeIntScanner("Choisissez le nombre de héros : ");
            // Liste des Heros du joueur
            this.liste_heros = new Combatant[nbCombatant];
            // Liste des Enemy
            this.liste_ennemis = new Combatant[nbCombatant];
        }


        public void createAllHeros() {
            // Creation des heros
            for (int i = 0; i < this.liste_heros.length; i++) {
                String name = SafeStringScanner("Héros " + (i+1) + " : Veuillez choisir le nom de votre héros : ");

                // Selection de la classe et creation du hero
                boolean confirm = false;
                int user;
                while (!confirm) {
                    // Selection de la classe
                    user = SafeIntScanner("Choisissez la classe du héros \" 1 : Hunter 2 : Warrior 3: Mage 4: Healer");
                    // Creation du hero en fonction de sa classe si
                    switch (user) {
                        case 1 : {this.liste_heros[i] = new Hunter(name, 50); confirm = true;}
                        case 2 : {this.liste_heros[i] = new Warrior(name, 50); confirm = true;}
                        case 3 : {this.liste_heros[i] = new Mage(name, 50, 10); confirm = true;}
                        case 4 : {this.liste_heros[i] = new Healer(name, 50, 10); confirm = true;}
                        //default : System.out.println("Merci de taper un nombre entre 1 et 4 ...");
                    }
                }
            }
        }

        public void Créationennemis() {
            for (int j = 0; j < this.liste_ennemis.length; j++) {
                Scanner scanner2 = new Scanner(System.in);
                System.out.println( "Ennemi " + (j+1) +" : Veuillez saisir le nom de l'ennemi: ");
                String ennemii = scanner2.next();
                this.liste_ennemis[j] = new Dragon(ennemii, 50);
            }
        }



        public static String getClassName(Class c) {
            String className = c.getName();
            int firstChar;
            firstChar = className.lastIndexOf('.') + 1;
            if (firstChar > 0) {
                className = className.substring(firstChar);
            }
            return className;
        }

        public void affichePlateau(){
            System.out.println("\n-----------------------------------------------------------------------------------");
            System.out.println(("Vague numéro : " + this.manche + "\n"));
            for (Combatant c : this.liste_heros) {
                System.out.println(getClassName(c.getClass())
                        + "[" + c.getName()
                        + "] : Point de vie = "
                        + c.getPointsvie()
                        + " | Dommage causé ="
                        + c.getDamage()
                );
            }
            for (Combatant c :this.liste_ennemis) {
                System.out.println(getClassName(c.getClass())
                        + "[" + c.getName()
                        + "] : Point de vie = "
                        + c.getPointsvie()
                        + " | Dommage causé = "
                        + c.getDamage()
                );
            }
            System.out.println("___________________________________________________________________________________");
        }

        public void afficheCamp(Combatant[] camp, String type){
            System.out.println("\n-----------------------------------------------------------------------------------");
            for (Combatant c : camp) {
                System.out.println(c.getClass() + " - " + c.getName() + " - " + c.getPointsvie());
                if (Objects.equals(type, "g")) {
                    // Affiche une list pour les combattants de class fille heros
                    System.out.println("                             " + Arrays.toString(((Hero) c).getBesacecombant()));
                }
            }
            System.out.println("-----------------------------------------------------------------------------------");
        }

        public int SafeIntScanner(String text) {
            System.out.println(text);
            while(true) {
                try {
                    Scanner sc = new Scanner(System.in);
                    return sc.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("Erreur, recommencez");
                }
            }
        }

        public String SafeStringScanner(String text) {
            System.out.println(text);
            while(true) {
                try {
                    Scanner sc = new Scanner(System.in);
                    return sc.nextLine();
                }
                catch (InputMismatchException e) {
                    System.out.println("Erreur, recommencez");
                }
            }
        }


    }
*/

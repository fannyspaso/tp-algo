package com.isep.rpg;
import java.util.*;

public class Game {

    boolean gameOver = false;
    int manche = 1;

    Combatant[] listeHeros;
    Combatant[] listeEnnemis;
    Combatant[] listeBoss = new Boss[1];

    public Game() {


        this.debutJeu();
        this.choixNbHeros();
        this.creerHeros();
        this.creerEnnemis();


        while (!this.gameOver) {
            this.affichePlateau();
            System.out.println("");

            Combatant[] listeCombatants = new Combatant[this.listeHeros.length + this.listeEnnemis.length];
            System.arraycopy(this.listeHeros, 0, listeCombatants, 0, this.listeHeros.length);
            System.arraycopy(this.listeEnnemis, 0, listeCombatants, this.listeHeros.length, this.listeEnnemis.length);
            List<Combatant> list = Arrays.asList(listeCombatants);
            Collections.shuffle(list);
            list.toArray(listeCombatants);


            // Créer un générateur de nombres aléatoires
            Random r = new Random();

            for (Combatant fighter : listeCombatants) {
                // Vérifier si "fighter" est dans la liste des ennemis
                if (Arrays.asList(this.listeEnnemis).contains(fighter)) {

                    // Générer un nombre aléatoire entre 0 et la longueur de la liste des héros
                    int randomNumber = r.nextInt(this.listeHeros.length);
                    Combatant ennemiis = listeHeros[randomNumber];

                    if (ennemiis.getPointsvie() <= 0) {
                        // Supprimer l'ennemi de la liste des héros
                        this.listeHeros = this.removeElement(this.listeHeros, randomNumber);
                        System.out.println(ennemiis.getName() + " est mort !");
                    }
                } else {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("\nChoisissez l'action pour " + fighter.getName() + " : " +
                            "\n[1] attaquer, " +
                            "\n[2] défendre, " +
                            "\n[3] utiliser un consommable");
                    int type_action = scanner.nextInt();
                    Random random1 = new Random();
                    int randomNumber = random1.nextInt(this.listeEnnemis.length);
                    // recuperation de la cible
                    Combatant ennemiis = listeEnnemis[randomNumber];


                    switch (type_action) {
                        case 1:

                            ennemiis.fight(fighter);
                            System.out.println("\nL'ennemi : " + ennemiis.getName() + " attaque le combatant : " + fighter.getName() + ", le héros perd donc " + ennemiis.getDamage() + " points de vie et il a " + fighter.getPointsvie() + " points de vie");
                            fighter.fight(ennemiis);
                            System.out.println("Le héros : " + fighter.getName() + " attaque l'ennemi : " + ennemiis.getName() + ", il perd donc " + fighter.getDamage() + " points de vie et il a " + ennemiis.getPointsvie() + " points de vie");

                            break;

                        case 2:
                            ennemiis.fight(fighter);
                            System.out.println("\nL'ennemi : " + ennemiis.getName() + " attaque le combatant : " + fighter.getName() + ", le héros perd donc " + ennemiis.getDamage() + " points de vie et il a " + fighter.getPointsvie() + " points de vie");
                            fighter.def(fighter.getPointsvie());
                            System.out.println("Le héros : " + fighter.getName() + " se protège de " + ennemiis.getName() + " et le héros : " + fighter.getName() + " gagne 2 points de vie et il a " + fighter.getPointsvie() + " points de vie");

                            break;

                        case 3:
                            ennemiis.fight(fighter);
                            System.out.println("\nL'ennemi : " + ennemiis.getName() + " attaque le combatant : " + fighter.getName() + ", le héros perd donc " + ennemiis.getDamage() + " points de vie et il a " + fighter.getPointsvie() + " points de vie");
                            System.out.println("\nLe héros a décidé d'utiliser un consommable");


                            Scanner scanner1 = new Scanner(System.in);
                            System.out.println("\nChoisissez le consommable qu'utilise " + fighter.getName() +
                                    "\n[1] Manger du lembas pour gagner des points de vie" +
                                    "\n[2] Autre nourriture pour gagner des points de vie" +
                                    "\n[3] Boire une potion pour restaurer la mana des lanceurs de sorts (que pour mage et healer)");
                            int conso = scanner1.nextInt();

                            switch (conso) {
                                case 1:
                                    fighter.pointsVieLembas(fighter.getPointsvie());
                                    System.out.print("\nGrace au lembas " + fighter.getName() + " gagne 2 points de vie et a " + +fighter.getPointsvie() + " points de vie");
                                    break;

                                case 2:
                                    fighter.pointsVieNourri(fighter.getPointsvie());
                                    System.out.print("\nGrace à la nourriture " + fighter.getName() + " gagne 4 points de vie et a " + fighter.getPointsvie() + " points de vie");
                                    break;

                                case 3:
                                    if (fighter instanceof SpellCaster) {
                                        fighter.addMana(fighter.getMana());
                                        System.out.print("\nGrace à la potion,la mana de " + fighter.getName() + " est restaurée : la mana du combatant est " + fighter.getMana());

                                    } else {
                                        System.out.println("Le héros doit être un mage ou un healer");
                                    }

                                    break;

                                default:
                                    System.out.println("Tapez un autre numéro ");

                            }
                    }

                    if (fighter.getPointsvie() > ennemiis.getPointsvie()) {
                        // Boucle qui permet à chaque Fighter de choisir son amélioration
                        // for (int i = 0; i < this.listeHeros.length; i++) {

                        Scanner sc = new Scanner(System.in);
                        System.out.println("\nFelicitations " + fighter.getName() + ", vous avez gagné votre combat !" +
                                "\nVous avez le droit à une recompense ! " +
                                "\n[1] Augmenter les dégâts causés" +
                                "\n[2] Augmenter votre résistance aux attaques" +
                                "\n[3] Augmenter l'efficacité de la potion et de la nourriture" +
                                "\n[4] Augmenter le nombre de potions ou de nourriture" +
                                "\n[5] Gagne deux flèches (pour le Hunter) ou diminuer le coût en mana pour les sorceleurs");
                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.println("\n" + fighter.getName() + " infligeait des dégâts de "+ fighter.getPvarme()+ " pv !");
                                fighter.increaseDamage();
                                System.out.println("Désormais il inflige des dégâts de " + fighter.getPvarme() + " pv !" + "\n" );
                                break;
                            case 2:
                                System.out.println("\n" + fighter.getName() + " avait "+ fighter.getPointsvie()+ " pv et il va en gagner grâce à la récompense !");
                                fighter.increasePointsVie();
                                System.out.println("Désormais " + fighter.getName() + " a "+ fighter.getPointsvie()+ " pv"+ "\n" );
                                break;
                            case 3:
                                System.out.println("\n" + fighter.getName() + " a une nourriture qui avait une efficacité de " + fighter.getFoodEfficiency() + " et a une potion qui avait une efficacité de " + fighter.getPotionEfficiency()+ "elles vont en gagner grâce à la récompense !");
                                fighter.increaseFoodEfficiency();
                                fighter.increasePotionEfficiency();
                                System.out.println("Désormais " + fighter.getName() + " a une nourriture qui a une efficacité de " + fighter.getFoodEfficiency() + " et a une potion qui a une efficacité de " + fighter.getPotionEfficiency() +"\n" );

                                break;
                            case 4:
                                System.out.println("\n" + fighter.getName() + " avait " + fighter.getNumFood() + " nourritures et avait " + fighter.getNumPotions()+ " potions, elles vont en augmenter grâce à la récompense !");
                                fighter.increaseNumFood();
                                fighter.increaseNumPotions();
                                System.out.println(fighter.getName() + " a désormais : " + fighter.getNumFood() + " nourrituree et a " + fighter.getNumPotions()+ "potions !" + "\n" );

                                break;
                            case 5:
                                if (fighter instanceof Hunter) {
                                    System.out.println("\nLe hunter " + fighter.getName() + " avait "+ fighter.getNumArrows()+ " flèches ");
                                    Hunter hunter = (Hunter) fighter;
                                    hunter.increaseNumArrows();
                                    System.out.println("Désormais, "+ fighter.getName() + " a " + fighter.getNumArrows()+ " flèches !" + "\n"  );
                                } else if (fighter instanceof SpellCaster) {
                                    System.out.println("\nLe lanceur de sorts : " + fighter.getName() + " avait "+ fighter.getMana()+ " mana ");
                                    SpellCaster sorcerer = (SpellCaster) fighter;
                                    sorcerer.diminuerMana();
                                    System.out.println("Désormais, il a " + fighter.getName() + " a "+ fighter.getMana()+ " mana " + "\n" );
                                } else if (fighter instanceof Warrior) {
                                    System.out.println("\n" + fighter.getName() + " est un Warrior, tu n'avais pas le droit à cette récompense ! Dommage !");
                                }
                                break;
                            default:
                                System.out.println("Option non valide, veuillez réessayer");
                        }
                        // }
                    }

                    // default: System.out.println("Tapez un autre numéro ");
                    //break;
                }


                if (this.listeEnnemis.length == 0 | this.listeHeros.length == 0) {
                    this.gameOver = true;
                    System.out.println("Un des deux camps n'a plus de combatants ... il a perdu le combat");
                    break;
                }
            }


            if (manche == 5) {


                //this.affichePlateau();
                this.gameOver = true;
                listeBoss[0] = new Boss("Boss final !!", 60);


                // Parcourir tous les héros restants dans la liste
                for (Combatant fighter : this.listeHeros) {

                    int randomNumber2 = 0;
                    Combatant Boss = listeBoss[randomNumber2];
                    // Faire combattre le héros contre le boss
                    System.out.println("ATTENTION !!!! Les héros vont affronter le boss final !!!");

                    while (Boss.getPointsvie() >= 0 & fighter.getPointsvie() >= 0) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("\nChoisissez l'action pour " + fighter.getName() +
                                "\n[1] attaquer, " +
                                "\n[2] défendre, " +
                                "\n[3] utiliser un consommable");
                        int type_action1 = scanner.nextInt();
                        Random random2 = new Random();
                        switch (type_action1) {
                            case 1:

                                Boss.fight(fighter);
                                System.out.println("\nLe Boss: " + Boss.getName() + " attaque le combatant : " + fighter.getName() + ", le héros perd donc " + Boss.getDamage() + " points de vie et il a " + fighter.getPointsvie() + " points de vie");
                                fighter.fight(Boss);
                                System.out.println("Le héros : " + fighter.getName() + " attaque le Boss : " + Boss.getName() + ", l'ennemi perd donc " + fighter.getDamage() + " points de vie et il a " + Boss.getPointsvie() + " points de vie");

                                break;

                            case 2:
                                Boss.fight(fighter);
                                System.out.println("\nLe Boss : " + Boss.getName() + " attaque le combatant : " + fighter.getName() + ", le héros perd donc " + Boss.getDamage() + " points de vie et il a " + fighter.getPointsvie() + " points de vie");
                                fighter.def(fighter.getPointsvie());
                                System.out.println("Le héros : " + fighter.getName() + " se protège de " + Boss.getName() + " et le héros : " + fighter.getName() + " gagne 2 points de vie et il a  " + fighter.getPointsvie() + " points de vie");

                                break;

                            case 3:
                                Boss.fight(fighter);
                                System.out.println("\nL'ennemi : " + Boss.getName() + " attaque le combatant : " + fighter.getName() + ", le héros perd donc " + Boss.getDamage() + " points de vie et il a " + fighter.getPointsvie() + " points de vie");
                                System.out.println("\nLe héros a décidé d'utiliser un consommable");


                                Scanner scanner1 = new Scanner(System.in);
                                System.out.println("\nChoisissez le consommable qu'utilise " + fighter.getName() +
                                        "\n[1] Manger du lembas pour gagner des points de vie" +
                                        "\n[2] Autre nourriture pour gagner des points de vie" +
                                        "\n[3] Boire une potion pour restaurer la mana des lanceurs de sorts (que pour mage et healer)");
                                int conso = scanner1.nextInt();

                                switch (conso) {
                                    case 1:
                                        fighter.pointsVieLembas(fighter.getPointsvie());
                                        System.out.print("\nGrace au lembas " + fighter.getName() + " gagne 2 points de vie et a " + +fighter.getPointsvie() + " points de vie");
                                        break;

                                    case 2:
                                        fighter.pointsVieNourri(fighter.getPointsvie());
                                        System.out.print("\nGrace à la nourriture " + fighter.getName() + " gagne 4 points de vie ! " + fighter.getPointsvie() + " points de vie");
                                        break;

                                    case 3:
                                        fighter.addMana(fighter.getMana());
                                        System.out.print("\nGrace à la potion,la mana de " + fighter.getName() + " est restaurée : la mana du combatant est " + fighter.getMana());
                                        break;

                                    default:
                                        System.out.println("\nTapez un autre numéro ");

                                }
                        }
                    }

                    // Si le boss est mort
                    if (Boss.getPointsvie() <= 0) {
                        // Afficher un message indiquant que le boss est mort
                        this.listeBoss = this.removeElement(this.listeBoss, randomNumber2);
                        System.out.println("\n" + Boss.getName() + " est mort ! Les héros sont gagnants ! BRAVOOOO !");
                        break; // Quitter la boucle

                    }

                    if (fighter.getPointsvie() <= 0) {
                        // Afficher un message indiquant que le boss est mort
                        this.listeHeros = this.removeElement(this.listeHeros, randomNumber2);
                        System.out.println("\n" + fighter.getName() + " est mort ! Les ennemis ont gagné... Vous ferez mieux la prochaine fois");
                        break; // Quitter la boucle
                    }
                }
                break;
            }
            this.manche++;
        }
    }

    private void debutJeu() {
        System.out.println("Bienvenue dans ton nouveau jeu !");
        System.out.println("");
    }


    public Combatant[] removeElement( Combatant [] arr, int index ) {
        // Créer une liste à partir du tableau
        List<Combatant> list = new ArrayList<>(Arrays.asList(arr));

        // Supprimer l'élément d'indice "index" de la liste
        list.remove(index);

        // Retourner la liste sous forme de tableau
        return list.toArray(new Combatant[0]);
    }




    public void choixNbHeros() {
        // Choix du nombre de Heros
        int nbCombatant = SafeIntScanner("Choisissez le nombre de héros : ");
        // Liste des Heros du joueur
        this.listeHeros = new Combatant[nbCombatant];
        // Liste des Ennemis
        this.listeEnnemis = new Combatant[nbCombatant];
    }




    public void creerHeros() {
        // Creation des heros
        for (int i = 0; i < this.listeHeros.length; i++) {
            String name = SafeStringScanner("\nHéros " + (i+1) + " : Veuillez choisir le nom de votre héros : ");

            // Selection de la classe et creation du hero
            boolean confirm = false;
            int classeheros;
            while (!confirm) {
                // Selection de la classe
                classeheros = SafeIntScanner("\nChoisissez la classe du héros " +
                        "\n[1] Hunter " +
                        "\n[2] Warrior " +
                        "\n[3] Mage " +
                        "\n[4] Healer");
                // Creation du hero en fonction de sa classe si
                switch (classeheros) {
                    case 1 :
                        this.listeHeros[i] = new Hunter(name, 50,2,6,3,3,3,3); confirm = true;
                        break;
                    case 2 : this.listeHeros[i] = new Warrior(name, 50,10,6,3,3,3,3); confirm = true;
                        break;
                    case 3 : this.listeHeros[i] = new Mage(name, 50, 10,2,2,6,3,3,2,2); confirm = true;
                        break;
                    case 4 : this.listeHeros[i] = new Healer(name, 50, 10,2,2,6,3,3,2,2); confirm = true;
                        break;
                    default : System.out.println("Merci de taper un nombre entre 1 et 4 ...");
                        break;
                }
            }
        }
    }



    public void creerEnnemis() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < this.listeEnnemis.length; i++) {
            System.out.println("\nEnnemi " + (i + 1) + " : Veuillez saisir le nom de l'ennemi: ");
            String ennemiName = scanner.next();
            this.listeEnnemis[i] = new Dragon(ennemiName, 50);
        }
    }




    public static String getClassName(Class c) {
        String className = c.getName();
        int firstChar = className.lastIndexOf('.') + 1;

        if (firstChar > 0) {
            className = className.substring(firstChar);
        }
        return className;
    }


    public void affichePlateau() {
        // Imprime une bordure en haut du plateau
        System.out.println("\n_________________________________________________________________________________________");

        // Imprime la vague actuelle
        System.out.println("Vague numéro " + this.manche + "\n");
        System.out.println("Vous avez choisi les combatants suivants : "+"\n");

        // Imprime les informations de chaque combattant
        for (Combatant c : this.listeHeros) {
            System.out.println(getClassName(c.getClass()) + "(" + c.getName() + ") : Points de vie = " + c.getPointsvie());
        }
        for (Combatant c : this.listeEnnemis) {
            System.out.println(getClassName(c.getClass()) + "(" + c.getName() + ") : Points de vie = " + c.getPointsvie());
        }
    }


    public int SafeIntScanner(String text) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(text);

            if (sc.hasNextInt()) {
                int input = sc.nextInt();

                if (input >= Integer.MIN_VALUE && input <= Integer.MAX_VALUE) {
                    return input;
                } else {
                    System.out.println("Erreur, la valeur saisie est en dehors de la plage des entiers représentables en Java");
                }
            }
        }
    }


    public String SafeStringScanner(String text) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(text);

            if (sc.hasNextLine()) {
                String input = sc.nextLine();

                try {
                    return input;
                } catch (InputMismatchException e) {
                    System.out.println("Erreur, recommencez");
                }
            }
        }
    }
}
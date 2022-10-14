import java.util.Scanner;
public class TP1 {
    public static void main(String[] args) {
        somme();
        volume();
    }
    public static void somme() {
        System.out.println("Veuillez saisir le premier entier");
        Scanner scanner = new Scanner(System.in);
        int premierEntier = scanner.nextInt();
        int deuxiemeEntier = scanner.nextInt();
        int somme = premierEntier + deuxiemeEntier;
        System.out.println("Veuillez saisir le deuxieme entier");
        System.out.println("La somme de " + premierEntier + " avec " + deuxiemeEntier + " est egale a " + somme);

        double division= premierEntier/deuxiemeEntier;
        System.out.println("la division de " + premierEntier + " par " + deuxiemeEntier + " est " + division);
    }

   public static void volume() {
       System.out.println("Veuillez saisir la longueur");
       Scanner scanner = new Scanner(System.in);
       int longueur = scanner.nextInt();
       System.out.println("Veuillez saisir la largeur");
       int largeur = scanner.nextInt();
       System.out.println("Veuillez saisir la hauteur");
        int hauteur = scanner.nextInt();
        int aire = longueur*largeur*hauteur;
       System.out.println("Le volume et  " + aire);
}
}
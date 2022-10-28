import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.TimeUnit;



public class TP5 {

    public static void main(String[] args) {
        initialiserTableau();

    }

    public static void initialiserTableau() {
        int SIZE= Integer.MAX_VALUE/ 1000;
        System.out.println(SIZE);

        int tabl [] = new int [SIZE];
        System.out.println(tabl.length);

        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        for (int i = 0; i < tabl.length; i++) {
            tabl[i] = random.nextInt(SIZE);
        }

        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");


        int[] tableauSelection = new int[SIZE];
// arraycopy(src, startIndex, dest, startIndex, size)
        System.arraycopy(tabl, 0, tableauSelection, 0, SIZE);
    }
/*
Questions 3.1.4:

tri par sélection: Chercher le plus petit élément de la partie non triée
 du tableau et on l’ajoute à la fin de la partie triée, et on répète jusqu’à avoir tout trié.
Complexité: On a deux boucles imbriquées.
• La première est répétée n fois.
• La deuxième est répétée n fois pour i = 0, n−1 fois pour i = 1, etc.
• La boucle intérieure contient une structure conditionnelle avec une opération. • La boucle extérieure contient, en plus de la boucle intérieure, 3 opérations.
• La complexité de l’algorithme est donc T(n) = 3n(n+(n−1)+···+1) = O(n2).

 */
        public static void triSelection(int[] tableauSelection){
            int SIZE= Integer.MAX_VALUE/ 1000;
            System.out.println(SIZE);

            int tabl [] = new int [SIZE];
            System.out.println(tabl.length);

            for (int i = 0 ; i < tableauSelection.length ; i++){
                int indiceMin = i ;
                for (int j = i ; j < tableauSelection.length ; j++){
                    if (tableauSelection[j] < tableauSelection[indiceMin])
                        indiceMin = j ;
                }
                int swap = tableauSelection[i] ;
                tableauSelection[i] = tableauSelection[indiceMin] ;
                tableauSelection[indiceMin] = swap ;
            }

                Instant start = Instant.now();
                System.out.println("Debut d’initialisation...");
                Random random = new Random();
                for (int i = 0; i < tableauSelection.length; i++) {
                    tableauSelection[i] = random.nextInt();
                }

                Instant end = Instant.now();
                long duration = Duration.between(start, end).toMillis();
                System.out.println("1L’initialisation a pris " + duration + " ms");

            int[] tableau = new int[SIZE];
// arraycopy(src, startIndex, dest, startIndex, size)
            System.arraycopy(tableauSelection, 0, tableau, 0, SIZE);

            }


/* Questions 3.1.5
tri par insertion: positionner correctement un élément du tableau non trié dans le tableau trié,
en le comparaison aux valeurs déjà triées.
Complêxité: Dans le pire des cas, le tableau est trié à l’envers et l’algorithme doit effectuer toutes les comparaisons de la boucle while, i.e. pour tout i, on arrive à j = 0.
• Dans ce cas-là, la boucle intérieure est parcourue n fois pour i = 0, n − 1 fois pour i = 1 et ainsi de suite.
• On a donc la même complexité que pour le tri par sélection, à savoir T(n) = O(n2).
 */


    public static void triInsertion(int[] tableau){
        int SIZE= Integer.MAX_VALUE/ 1000;
        System.out.println(SIZE);

        int tabl [] = new int [SIZE];
        System.out.println(tabl.length);
        for (int i = 0 ; i < tableau.length ; i++){
            int elementATrier= tableau[i]; ;
             int j = i;
                while (j >  0 && tableau[j-1]> elementATrier){
            tableau[j] = tableau[j-1] ;
            j-- ;
                }
    tableau[j]= elementATrier;
}
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt();
        }

        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("1L’initialisation a pris " + duration + " ms");

    }
        }
import java.util.Scanner;
public class TP2 {


    public static void discriminant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();

        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();

        System.out.println("Quelle est la valeur de c ?");
        int c = scanner.nextInt();

        int delta = (int) (Math.pow(b, 2) - 4 * a * c);
        System.out.println("delta: " + delta);
        if (delta < 0) {
            System.out.println("Ce polynome n’a pas de racine reelle");
        }
        else if (delta == 0) {
            int racinedouble = (-b)/(2*a) ;
            System.out.println("Ce polynome a une racine double réelle qui est " + racinedouble);
        }
        else if (delta > 0) {
            double racines= ((-b)+Math.sqrt(delta))/(2*a) ;
            double raciness= ((-b)-Math.sqrt(delta))/(2*a);
            System.out.println("Ce polynome a 2 racines reelles "+ racines + " et "+ raciness);
        }

    }
    public static void parite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un entier ");
        int entier = scanner.nextInt();

        System.out.println(entier%2);

        if (entier % 2 == 0 ) {
            System.out.println("Le nombre "+ entier + " est pair");
        }
        else
            System.out.println("Le nombre "+ entier + " est impair");
    }
    public static void max() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un premier entier ");
        int a = scanner.nextInt();

        System.out.println("Saisir un deuxième nombre entier ");
        int b = scanner.nextInt();
        if (a > b) {
            System.out.println(a +"est supérieur à " + b );
        }
        else if (a< b ) {
            System.out.println(b + "est supérieur à " + a);
        }}

    public static void min() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un premier entier ");
        int a = scanner.nextInt();

        System.out.println("Saisir un deuxième nombre entier ");
        int b = scanner.nextInt();
        if (a < b) {
            System.out.println( a + " est inférieur à " +b );
        }
        else if (a> b ) {
            System.out.println(b + " est inférieur à"+  a);
        }
    }
    public static void egaliteStr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir une chaine de caractères ");
        String a = scanner.next();

        System.out.println("Saisir une deuxième chaine de caractères ");
        String b = scanner.next();
        boolean test = a.equals(b);

        System.out.println(test );

        if (test == true)
            System.out.println("Ces chaines sont égales ");
        else if (test == false)
            System.out.println("Ces chaines ne sont pas égales ");
    }

    public static void factorielle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier positif ou nul");
        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            int factorielle = 1;
            factorielle *= i;
            System.out.println(n + "! = " + factorielle);

        }
    }

    public static void main(String[] args) {
        //  discriminant();
        //parite();
        //max();
        //  min();
        //     egaliteStr();
        factorielle();
    }

        /* tableau
        // Si on connait tous les elements
        int[] tableauConnu = {4, 1, -1, 0};
        int unElement = tableauConnu[3];
// Si on ne connait que la taille
        String[] tableauInconnu = new String[4];*/

    //Calculer le discriminant


}



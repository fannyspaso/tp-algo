import java.util.Scanner;
import java.io.InputStream;

//SafeScanner
public class SafeScanner
{
    Scanner sc;

    public SafeScanner(InputStream is)
    {
        this.sc = new Scanner(is);
    }

    public int getInt()
    {
        int input = this.sc.nextInt();
        return input;
    }

    public int[] getDimFromFile()
    {
        String input = this.sc.nextLine();
        int[] dim = new int[2];
        dim[0] = input.charAt(0) - '0';
        dim[1] = input.charAt(2) - '0';
        return dim;
    }

    public void closeScanner()
    {
        this.sc.close();
    }
}

//exo ascii avec le chat, he following exercise is simple: write a function that takes height and width parameters and prints a cat of the appropriate size, such as in Figure 2.
public class ascii
{

    private static int width, height;

    public ascii()
    {
    }

    public static void drawCat(int height, int width)
    {

        // oreilles et un peu de tête
        System.out.print("|\\");
        printCharLoop(width-4,'-');
        System.out.println("/|");

        // un peu de t^^e et yeux
        for(int i=1;i<height-1;i++)
        {
            System.out.print("|");
            if(i==height/2)
            {
                System.out.print(" ");
                System.out.print("0");
                printCharLoop(width-6,'_');
                System.out.print("0");
                System.out.print(" ");
            }
            else
            {
                printCharLoop(width-2,' ');
            }
            System.out.println("|");
        }

        // fin de la tête
        System.out.print(" \\_");
        printCharLoop(width-6,'^');
        System.out.println("_/ ");
    }

    private static void printCharLoop(int n, char c)
    {

        for(int i=0;i<n;i++)
        {
            System.out.print(c);
        }
    }
}

import java.util.Objects;
        import java.util.*;

public class Main
{
    public static void main(String [] args)
    {
        int height=0,width=0;
        ascii cat = new ascii();
        boolean inputGood = false;


        while(!inputGood)
        {
            try
            {
                SafeScanner sc = new SafeScanner(System.in);
                System.out.print("Entrer la taille du chat (>3) : ");
                height = sc.getInt();
                System.out.print("Entrer la largeur du chat (<7) : ");
                width = sc.getInt();
                inputGood = true;
                sc.closeScanner();
            }
            catch(Exception e)
            {
                System.out.println("Entrer un entier ");
            }
        }

        if(height>=3 && width>=7)
        {
            cat.drawCat(height,width);
        }
        else
        {
            System.out.println("Cela n'est pas possible,les dimensions minimales sont 3x7");
            System.exit(0);
        }

    }
}


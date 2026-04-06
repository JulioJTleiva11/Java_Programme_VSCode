package op02Exercises;

import java.util.Scanner;

public class Eingabe {
    @SuppressWarnings("resource")
    public static void main (String[] args){
        int laenge, breite, flaeche;
        
        //eingabe 1
        Scanner eingabewert = new Scanner(System.in);
        System.out.println("Geben Sie die Länge ein in cm: ");
        laenge = eingabewert.nextInt(); //nextDouble(); nextLine(); next();
        System.out.print("Eingabe der Länge: " + laenge);

        System.out.println();

        //eingabe 2
        System.out.print("Geben Sie die Breite ein in cm: ");
        Scanner eingabewert2 = new Scanner(System.in);
        breite = eingabewert2.nextInt();
        System.out.print("Eingabe der Breite: " + breite);
        
        System.out.println();
        
        //berechnung der Fläche
        //System.out.println("Berechnung der Fläche: " + breite*laenge+1);
        
        flaeche = laenge * breite;
        System.out.println("Berechnung der Fläche: " + flaeche + " Quadratzentimeter.");
    }
}

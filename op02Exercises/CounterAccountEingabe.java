package op02Exercises;

import java.util.Scanner;

public class CounterAccountEingabe {
    //Attributs
    private static int nextKontonummer = 1111; 
    private String Kontoinhaber;
    private int kontonummer;
    private double kontostand;
    //private String kontobewegung;//letzte kontobewegung

    //**************************************************************
    //konstruktor
    public CounterAccountEingabe(String kontoinhaber, int kontonummer, double kontostand) {
        Kontoinhaber = kontoinhaber;  //HIER BEACHTE; STRING-Konstruktor WIRD GROß & OHNE this GESCHRIEBEN!!!
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
    }
    
    //**************************************************************
    //getter && Setter
    public String getKontoinhaber() {
        return Kontoinhaber;
    }
    public void setKontoinhaber(String kontoinhaber) {
        Kontoinhaber = kontoinhaber;
    }

    public static int getNextKontonummer() {
        return nextKontonummer;
    }
    public static void setNextKontonummer(int nextKontonummer) {  //setter von static ohne THIS
        CounterAccountEingabe.nextKontonummer = nextKontonummer; //ohne THIS
    }

    public int getKontonummer() {
        return kontonummer;
    }
    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }

    public double getKontostand() {
        return kontostand;
    }
    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    //*****************************************************************
    //Methods: leseStringEingabe
    public static String leseStringEingabe(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Ihr Name: ");
        String kontoinhaber = scanner1.nextLine();
        //scanner1.close();
        return kontoinhaber;
    }

    //Methods:generiereNeueKontonummer
    private static int generiereNeueKontonummer (){
        nextKontonummer++;
        return nextKontonummer;
    }
    //Methods: einzahlung payIn
    public void einzahlung(double eingabewert){  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wie viel zum Einzahlen: ");
        eingabewert = scanner.nextDouble();  
        System.out.println("Ihre Einzahlung: " + eingabewert);
        //scanner.close();
        kontostand += eingabewert;
    }

    //Methods: auszahlung payOut
    public void auszahlung(double eingabewert){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viel zum Auszahlen: ");
        eingabewert = scanner.nextDouble();
        System.out.println("Ihre Auszahlung: " + eingabewert);
        //scanner.close();
        kontostand -= eingabewert;
    }

    //Methods: info()
    public void info(){
        System.out.println("Guten Tag! Hier ist die Hamburger Bank");
    }
    //*****************************************************************
    //main
    public static void main(String[] args) {
        //Neue Objects
        CounterAccountEingabe neuesKonto = new CounterAccountEingabe(leseStringEingabe(), 
                                              CounterAccountEingabe.getNextKontonummer(), // geht auch: nextKontonummer
                                               0.0);
        
        //Variablen
        //String neuesKonto1 = leseStringEingabe();//Methode an Variable übergeben
        

        //BenutzerEingabe 1
        System.out.println("Kontoinhaber: " + neuesKonto.getKontoinhaber() + " Kontonummer: " + CounterAccountEingabe.generiereNeueKontonummer());
        
        System.out.print("wollen Sie einzahlen? j/n: ");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        //reader.close(); // close scanner after reading
        if ("j".equals(input)) {            //WICHTIGvergleichSTRINGeingabe
            neuesKonto.einzahlung(-1); //das neue Object zu der Fkt übergeben
            System.out.println();
            System.out.println("neuer Kontostand: " + neuesKonto.getKontostand());
        }
        else if ("n".equals(input)) {
            return; // Programm beenden mit return
        }
        
        System.out.print("wollen Sie Auszahlen? j/n: ");
        Scanner reader2 = new Scanner(System.in);
        String input2 = reader.next();
        if("j".equals(input2)){
            neuesKonto.auszahlung(-1);
            System.out.println();
            System.out.println("neuer Kontostand: " + neuesKonto.getKontostand());
        }else if ("n".equals(input2)) {
            return; // Programm beenden mit return
        }

        //BenutzerEingabe 2 ab hier lieber in einer switch case
        System.out.println("neues Kontoeröffnen? ");
        Scanner reader3 = new Scanner(System.in);
        String input3 = reader.next();
        if("j".equals(input3)){
            CounterAccountEingabe neuesKonto2 = new CounterAccountEingabe(leseStringEingabe(), nextKontonummer, 0.0);
            System.out.println();
            System.out.println("Kontoinhaber: " + neuesKonto2.getKontoinhaber() + " Kontonummer: " + CounterAccountEingabe.generiereNeueKontonummer());
            neuesKonto2.setKontostand(1111111);
            System.out.println("neuer Kontostand: " + neuesKonto2.getKontostand());
        }
        else if ("n".equals(input3)) {
            return; // Programm beenden mit return
        }
        
        
        
        //AB HIER WIRD NOCH WEITERGEÜBT!!! 

        System.out.println();
        
        System.out.println();
    }
    
}

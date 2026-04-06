package op02Exercises;

import java.util.Scanner;

public class BankSystem {

    private static double kontostand = 1000.0; // Startwert für den Kontostand

    // Methode für Einzahlung
    public static void einzahlung(double betrag) {
        if (betrag > 0) {
            kontostand += betrag;
            System.out.println("Einzahlung erfolgreich! Neuer Kontostand: " + kontostand);
        } else {
            System.out.println("Ungültiger Betrag!");
        }
    }

    // Methode für Auszahlung
    public static void auszahlung(double betrag) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
            System.out.println("Auszahlung erfolgreich! Neuer Kontostand: " + kontostand);
        } else {
            System.out.println("Ungültiger Betrag oder unzureichender Kontostand!");
        }
    }

    // Methode für Überweisung
    public static void ueberweisung(double betrag, String empfaenger) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
            System.out.println("Überweisung an " + empfaenger + " erfolgreich! Neuer Kontostand: " + kontostand);
        } else {
            System.out.println("Ungültiger Betrag oder unzureichender Kontostand für Überweisung!");
        }
    }

    // Methode zur Anzeige der Kontoinformationen
    public static void kontoinformationen() {
        System.out.println("Ihr aktueller Kontostand ist: " + kontostand);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWählen Sie eine Aktion:");
            System.out.println("1. Einzahlung");
            System.out.println("2. Auszahlung");
            System.out.println("3. Überweisung");
            System.out.println("4. Kontoinformationen");
            System.out.println("5. Beenden");
            System.out.print("Ihre Wahl: ");
            int wahl = scanner.nextInt();

            switch (wahl) {
                case 1:
                    System.out.print("Geben Sie den Betrag für die Einzahlung ein: ");
                    double betragEinzahlung = scanner.nextDouble();
                    einzahlung(betragEinzahlung);
                    break;

                case 2:
                    System.out.print("Geben Sie den Betrag für die Auszahlung ein: ");
                    double betragAuszahlung = scanner.nextDouble();
                    auszahlung(betragAuszahlung);
                    break;

                case 3:
                    System.out.print("Geben Sie den Betrag für die Überweisung ein: ");
                    double betragUeberweisung = scanner.nextDouble();
                    System.out.print("Geben Sie den Empfänger der Überweisung ein: ");
                    scanner.nextLine(); // Scanner-Buffer leeren
                    String empfaenger = scanner.nextLine();
                    ueberweisung(betragUeberweisung, empfaenger);
                    break;

                case 4:
                    kontoinformationen();
                    break;

                case 5:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return; // Beendet das Programm

                default:
                    System.out.println("Ungültige Wahl, bitte versuchen Sie es erneut.");
                    break;
            }
        }
    }
}

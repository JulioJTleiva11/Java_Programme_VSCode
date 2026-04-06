package op02Exercises;

public class PunktenAuswertung {
    
    // Enum für die Schulnoten mit Punktbereichen
    public enum Note {
        SEHR_GUT(80, 100, "Sehr gut"),
        GUT(70, 79, "Gut"),
        BEFRIEDIGEND(60, 69, "Befriedigend"),
        AUSREICHEND(40, 59, "Ausreichend"),
        MANGELHAFT(0, 39, "Mangelhaft");

        private final int untereGrenze;
        private final int obereGrenze;
        private final String bezeichnung;

        // Konstruktor
        private Note(int untereGrenze, int obereGrenze, String bezeichnung) {
            this.untereGrenze = untereGrenze;
            this.obereGrenze = obereGrenze;
            this.bezeichnung = bezeichnung;
        }

        // Getter für die Punktbereiche
        public int getUntereGrenze() {
            return untereGrenze;
        }

        public int getObereGrenze() {
            return obereGrenze;
        }

        // Getter für die Bezeichnung der Note
        public String getBezeichnung() {
            return bezeichnung;
        }
        
        // Methode zur Bestimmung der Note basierend auf den Punkten
        public static String bestimmeNote(int punkte) {
            for (Note note : Note.values()) {
                if (punkte >= note.getUntereGrenze() && punkte <= note.getObereGrenze()) {
                    return note.getBezeichnung();
                }
            }
            return "Ungültige Punktzahl";
        }
    }

    public static void main(String[] args) {
        // Test: Punktzahl wird geprüft und die Note ausgegeben
        int[] punkteArray = {95, 72, 65, 55, 39, 82, 49};

        // Iteration durch die Punktzahlen und Ausgabe der zugehörigen Note
        for (int punkte : punkteArray) {
            String note = Note.bestimmeNote(punkte); //Variable erzeugen für die Überprüfung in der Methode bestimmeNote
            System.out.println("Punkte: " + punkte + " -> Note: " + note);
        }

        // Ausgabe der Noten mit ihren Punktbereichen und Bezeichnungen
        System.out.println("\nNoten und Punktbereiche:");
        for (Note note : Note.values()) {
            //System.out.println(note.name() + ": " + note.getBezeichnung() 
            //    + " (Punkte: " + note.getUntereGrenze() + " bis " + note.getObereGrenze() + ")");
            System.out.println("Notenbezeichnung: " + note.getBezeichnung() 
                + " (Punkte: " + note.getUntereGrenze() + " bis " + note.getObereGrenze() + ")");
        
            }
    }
}


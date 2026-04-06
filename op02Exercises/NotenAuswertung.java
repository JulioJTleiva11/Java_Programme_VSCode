package op02Exercises;

public class NotenAuswertung {
    
    // Enum für die Schulnoten
    public enum Note {
        A("Sehr gut"),
        B("Gut"),
        C("Befriedigend"),
        D("Ausreichend"),
        E("Mangelhaft"),
        F("Ungenügend");

        private final String bezeichnung;

        // Konstruktor
        Note(String bezeichnung) {
            this.bezeichnung = bezeichnung;
        }

        // Getter für die Bezeichnung der Note
        public String getBezeichnung() {
            return bezeichnung;
        }
    }

    public static void main(String[] args) {
        // Array mit Noten
        Note[] noten = Note.values();

        // Iteration durch alle Noten mit einer for-each Schleife
        for (Note note : noten) {
            // Ausgabe der Note und ihrer Bezeichnung
            System.out.println("Note: " + note.name() + " - " + note.getBezeichnung());
        }
    }
}

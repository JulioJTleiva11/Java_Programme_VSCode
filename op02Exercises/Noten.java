package op02Exercises;

public enum Noten {
    //Eigenschaten initialiseren bzw. zuweisen (0,100)
    SEHR_GUT(80,90, "sehr gut"), 
    GUT(70,79, "gut"), 
    BEFRIEDIGEND(60,79, "befriedigend"), 
    AUSREICHEND(40,59,"ausreichend"), 
    MANGELHAFT(0,39, "mangelhaft"); //HIER ENDET DIE VARIABLEN DES ENUMS MIT SEMIKOLON ;

    //weitere Eingeschaften 
    private int from;
    private int to;  //konstruktor für die beiden bauen
    private static String fromToUndBezeichnung;
    private String notenBezeichnung;

    //Konstruktor MUSS PRIVATE IN ENUMS
    private Noten(int from, int to, String notenBezeichnung){
        this.from = from;
        this.to = to;
        this.notenBezeichnung = notenBezeichnung;        
    }

    //Methods: hol dir die Noten als String
    public String ausgabeNoten(){
        //return "From: " + from + " - " + "To: " + to; 
        return from + " - " + to + " :" + getNotenBezeichnung(); //wichtigReturn
    }
    
     //Methods: getter notenBezeichnung
     public String getNotenBezeichnung(){
        return notenBezeichnung;
     }

    //die Noten ausrechnen
    private static String notenAusrechnen(int punkte){
        for(Noten n : Noten.values()){
            //wenn die Punkte in einer Schranke liegen, zwischen n.from und n.to
            if(n.from <= punkte && punkte <= n.to){  // unten < punkte < oben  //wichtigObenUnten
                fromToUndBezeichnung = n.ausgabeNoten();
                return fromToUndBezeichnung;
            }
        }
        //return MANGELHAFT; //zum beispiel
        return fromToUndBezeichnung;
    }

    public static void main(String[] args) {
        int punkteArr = 73;
        String note = Noten.notenAusrechnen(punkteArr);  //wichtigAuswertung
        System.out.println(note);
        
    }

     
}


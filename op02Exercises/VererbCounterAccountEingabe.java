package op02Exercises;


public class VererbCounterAccountEingabe extends CounterAccountEingabe{
    //Attributs
    private double limit;

    //konstruktor
    public VererbCounterAccountEingabe(String Kontoinhaber, int kontonummer, double kontostand, double limit){
        super(Kontoinhaber, kontonummer, kontostand);
        this.limit = limit;                          
    }

    //getter und setter //methods: limit setzen
    public void setLimit(double limit) {
        if(limit >= 0.0){
            this.limit = limit;
        }
        else {
            limit = 0.0;
        }
    }
    
    //methods: @override auszahlung
    @Override //markierung, die den compiler über eine Überschreibung aus einer Oberklasse-Methode informiert
    public void auszahlung(double eingabewert) {
        // TOdO Auto-generated method st
        //super.auszahlung(eingabewert);
        //hier aufrufen mit get.kontostand(), da unterklasse von CounterAccountEingabe
        double kontostand = getKontostand(); 
        if(kontostand - eingabewert >= -limit){
            kontostand -= eingabewert;
            setKontostand(kontostand);
        }
    }

    //methods: @override einzahlung
    @Override
    public void einzahlung(double eingabewert) {
        // TOdO Auto-generated method stub
        super.einzahlung(eingabewert);
    }

    //Methods: info()
    @Override
    public void info() {
        // TOdO Auto-generated method stub
        super.info();//hier wird die Info()-Methode der Oberklasse ausgeführt
        System.out.println("hier ist Ihr Limit: " + limit);
        System.out.println();
    }

    //main
    public static void main(String[] args) {
        //UPcast nicht-gefährlich Unterklasse zu Oberklasse ....... DownCast ist aber sehr-gefährlich

        //schlechtes beispiel...
        //CounterAccountEingabe subneuesKonto = new VererbCounterAccountEingabe(CounterAccountEingabe.leseStringEingabe(), 
        //VererbCounterAccountEingabe.getNextKontonummer(), 0.0, 2000.0);
        
        

    }

}

package op02Exercises;

public class InnereInstanzKlasseA { //Beginn Class A
    //Attribute
    public static int x = 42;
    public int y;

    //Konstruktor
    public InnereInstanzKlasseA() { //hier wird gelöscht int y als parameter, sin Parameter solamente que haga lo que este en {...}
        this.y = x++; //hier wurde anstaat this.y = y; für this.y = x++; ersetzt. Also man darf hier manipulieren
    } 

    //Instanz Innere Klasse B
    public class B{
        //Attribute
        public int z;
        
        //Konstruktor
        public B() {//hier wird gelöscht int z als parameter, sin Parameter solamente que haga lo que este en {...}
            //this.z = z; hier wird manipuliert
            this.z = y * x;
        }
    }//End von Class B

    // Main
    public static void main(String[] args) {
        //Erzeugen von einem Object für die Klasse A
        InnereInstanzKlasseA a = new InnereInstanzKlasseA();
        //Erzeugen von einem Object für die innere InstanzKlasse B
        InnereInstanzKlasseA.B b = a.new B(); //HIER BEACHTEN SIGNATUR BEIM AUFRUF INNERE INSTANZ KLASSE !!!
        System.err.println("a.y : " + a.y + " b.z : " + b.z);
    
    }//End of Main

} //End von Class A

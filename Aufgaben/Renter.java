package Aufgaben;

/**
 * This class models renters of flats in a building. 
 * 
 * @author DRK
 */
public class Renter {
    //Attribute
    private String name;
    private int squareMeter;
    private int persons;

    /**
	 * Constructor getting all defined values.
	 * @param name
	 * @param squareMeter
	 * @param persons
	 */
    //Constructor
    public Renter(String name, int squareMeter, int persons){
        super();
        this.name = name;
        this.squareMeter = squareMeter;
        this.persons = persons;
    }

    //evt. Getter und Setter
    public String getName(){
        return name;
    }

    public int getSquareMeter(){
        return squareMeter;
    }

    public int getPersons(){
        return persons;
    }

    //toString methode + @Override! zum Aufruf der Info
    @Override //es gehört zu guten Programmierstill und um (Syntax)Fehler zu meiden
    public String toString(){
        return name;
    }

    // Array als Konstante, die global innerh. des Prog. verfügb.
    public static final Renter[] rentersInPasadena = { //Array 
        new Renter("Penny", 50, 1),
        new Renter("Dr. Cooper", 75, 2),
        new Renter("H. Wolowitz", 65, 2),
        new Renter("Dr. Koothrappali", 45, 1)
    };
}

















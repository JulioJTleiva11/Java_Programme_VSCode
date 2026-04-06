package op02Exercises;

public class User {
    //Attribute
    private int userId;
    private Permissions perm;// da jeder User verschiede Rechte hat, sinnvoll für innere Klassen!

    //Konstruktor
    public User(int userId) {//das geht nicht:(int userId, !!!Permissions perm!!!)
        this.userId = userId;
        //this.perm = perm;  //das geht nicht, da Permission eine (innere) Klasse ist?
        perm = new Permissions(); //quasi ein Konstruktor in dem Kosntruktor...da static innereKlasse?
    }

    //Methods: getter
    public int getUserId() {
        return userId;
    }

    //Methods: getter der Inneren Klasse
    public Permissions getPerm() {
        return perm;
    }

    //innere Klasse
    public static class Permissions { //public statische innere Klasse!!!
        //Attribute der innere Klasse
        public boolean canRead;
        public boolean canWrite;
        public boolean canDelete;


    }

}

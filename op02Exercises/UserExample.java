package op02Exercises;

public class UserExample {

    public static void main(String[] args) {
        //neu User erzeugen mit Hilfe Konstruktor
        User user1 = new User(7777);

        //user1 hat nur leseRechte (get==bekomme) (set==lege fest)
        //Aufruf der innere Klasse: äußereClass.InnereClass attributName
        User.Permissions permissions = user1.getPerm();//user.Permissions ==äußereClass.InnereClass AttributName...
        permissions.canRead = true; //ein Permission auf true gesetzt! andere false

        // in der println neue Zeile erzeugen mit \n
        System.out.println("Read : " + permissions.canRead + "\nWrite : " + permissions.canWrite + "\nDelete : " + permissions.canDelete);
        //System.out.println("Write : " + permissions.canWrite);
        //System.out.println("Delete : " + permissions.canDelete);


    }

}

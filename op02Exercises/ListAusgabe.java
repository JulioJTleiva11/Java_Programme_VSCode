package op02Exercises;

import java.util.Iterator;

public class ListAusgabe {

    public static void main(String[] args) {
        ListStruktur myList = new ListStruktur();  //neuer Liste erstellen

        //Eintragun in der Liste
        myList.add(new String("Buenos"));
        myList.add(new String("Dias"));
        myList.add(new String("Hamburgo"));
        myList.add(new String("!!!"));

        //Aufruf von iterator
        Iterator<Object> member = myList.iterator();
        while(member.hasNext()){
            System.out.println(" Element : " + member.next());
        }
    }

}

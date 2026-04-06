package op02.innerclasses;

import java.util.Iterator;

public class ListExample {

  public static void main(String[] args) {
    
    List myList = new List();//neuer Liste erstellen
    
    //Eintragun in der Liste
    myList.add(new String("Alpha"));
    myList.add(new String("Beta"));
    myList.add(new String("Gamma"));
    
    Iterator<Object> it = myList.iterator();
    
    while ( it.hasNext() ) {
      System.out.println(" Element : " + it.next());
    }
    
  }
  
}

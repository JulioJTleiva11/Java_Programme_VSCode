package op04;
import java.util.Vector;

/**
 * Simple class to demonstrate the use of vectors.
 * 
 * <p>Adaption of class VectorTest1 from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class CustomerVectorExample {
  /**
   * Constructs a vector of customers and prints them.
   * @param args not used here
   */
  public static void main(String[] args) {
    // Customer(Kunde)-Vector
    //Customer [] costumers = new Customer[100]; //hier entspricht das gleiche wie unten, nur als Array von Customer
    Vector<Customer> customers = new Vector<Customer>(); // WICHTIGVectorDeklaration ein vector mit Customer-Objekte

    //Die Funktion add() gehört zur Class Vector() und hat 2 Möglichkeiten, mit & ohne Indexeingabe 
    customers.add(new Customer("C3PO", "Stiftstraße 69"));
    customers.add(new Customer("BB8", "Berliner Tor 5"));
    customers.add(0, new Customer("R2D2", "Berliner Tor 7"));

    // 2x Ausgabe von VectorElemente
    for (int i = 0; i < customers.size(); i++) {  //size() wie viele Elemente aktuell in diesem Vector gibt
      Customer c = customers.get(i); // No cast necessary  //get(i) 
      //Customer c = customers.set( 1,"abcd, av. Lima"); // set a[ index ] = element
      System.out.println(c.getName() + ", " + c.getAddress());
    }

    System.out.println();
    for (Customer c : customers) { // alternative syntax mit For Each Schleife nur für Ausgabe
      System.out.println(c.getName() + ", " + c.getAddress());
    }
    //customers.clear (); // make it empty
    //if (customers.contains(parameter)){}// is obj stored ?
    //if (customers.isEmpty ()){// is size ()==0?    
    //} 
    
  }
}



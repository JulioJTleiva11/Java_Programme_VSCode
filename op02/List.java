package op02;
/**
 * A simple class for a List.
 * 
 * <p>Adaption of class Liste from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

import java.util.Iterator;

public class List {
  //Attribute
  //Attribute der static innereKlasse
  private Element head;
  private Element tail;

  //static innereKlasse
  private static class Element {
    private Object obj;
    private Element next;
  }

  /**
   * Adds an object to the end of the list.
   * @param obj the object to add
   */
  public void add(Object obj) {
    if (obj == null) { // ignore nulls!
      return;
    }
    Element elementToAdd = new Element(); // neues Object/Element erzeugt
    elementToAdd.obj = obj;

    if (head == null) {    
      head = tail = elementToAdd;
    } else {
      tail.next = elementToAdd;
      tail = elementToAdd;
    }
  }

  /**
   * Constructs an iterator for the list.
   * @return a reference to an iterator
   */
  public Iterator<Object> iterator() { // iterator()ist eine Methode in einer Klasse
    // lokale Klasse constructed in method
    class IteratorImpl implements Iterator<Object> { //IteratorImpl ist List Iterator
      //zugriff auf die statische innere Klasse Element
      private Element current = head;  // Referenz current auf head, den Kopf der Liste

      @Override
      public boolean hasNext() {
        //so ist nicht effizient programmiert!
        //if (current == null) return false;
        //else return true;
        //besser, wenn current != null ist, dann gibt es den nächsten
        return current != null; //return solange ein neues Element nicht null ist
      }

      @Override
      public Object next() {
        //sicherung ob ein Nächsten gibt
        if (current == null) {
          return null;
        } 
        
        Object obj = current.obj;
        current = current.next;
        return obj;
      }
    } // end of IteratorImpl
    
    return new IteratorImpl(); //baue einen Iterator für die List

    
    /*
     * Resume: 
     * Iterator ist eine Methode von Java notwendig  für die Iteraktion einer List.
     * Methode bauen: public Iterator<Object> iterator(){...}
     * in dieser Methode wird ein Object iteriert und zurückgegeben
     * welches Object zurückgibt? das wird in der lokalen Klasse class IteratorImpl implements Iterator<Object>{}
     * Quick Fix sagt einem welche Methode müssen implementiert werden
     */
  }
}



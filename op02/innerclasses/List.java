package op02.innerclasses;
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
    Element elementToAdd = new Element();
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
  public Iterator<Object> iterator() { // a method 
    // anonymous class constructed in method
    return new Iterator<Object>() {  // anonymous class:  new Iterator<Object>() {}
      private Element current = head;

      public boolean hasNext() {
        return current != null;
      }

      public Object next() {
        if (current == null) {
          return null;
        } 
        Object obj = current.obj;
        current = current.next;
        return obj;
      }
    }; 
  }
}



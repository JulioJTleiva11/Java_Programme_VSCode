package op02.constructors;

/**
* Very basic class with initialisation and basic constructor.
* 
* <p>Adaption of class B from D. Abts
* @author Henning Dierks
* @version 1.0
*/
public class B extends A {
  {
    System.out.println("Initialisation B");
  }
  
  public B() {
    System.out.println("Body of Constructor B");
  }
}

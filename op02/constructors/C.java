package op02.constructors;

/**
 * Very basic class with initialisation and basic constructor.
 * 
 * <p>Adaption of class C from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class C extends A {
  {
    System.out.println("Initialisation C");
  }

  public C() {
    System.out.println("Body of Constructor C");
  }

  public static void main(String[] args) {
    new C();
  }
}

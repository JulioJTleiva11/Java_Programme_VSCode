package op04;
/**
 * Example to demonstrate the effects of cloning. 
 * 
 * @author Henning Dierks
 * @version 1.1
 */

public class CloneExample implements Cloneable {   // 1. implements Cloneable
  public Complex left;
  public Complex right; // two complex numbers

  // Constructor
  public CloneExample() {
    left = new Complex(1,0);
    right = new Complex(0,1);
  }

  @Override
  public String toString() {
    return "L : (" + left.getReal() + "," 
                   + left.getImaginary()
      +  ") R : (" + right.getReal() + ","  
                   + right.getImaginary()
      +  ")";
  }

  @Override
  public CloneExample clone() { // shallow copy!            //3. Try-Catch einbauen
    try { // always call super.clone() first! 
      return (CloneExample) super.clone(); // cast needed!   //4. es muss gecastet werden!!!
    } catch (CloneNotSupportedException e) {
      return null; // should not occur...
    }
  }

  /**
   * Show the effects of cloning.
   * @param args not used here
   */
  public static void main(String[] args) {
    CloneExample original = new CloneExample();
    CloneExample cloned = original.clone();  // 2. neues Object erzeugen der Klassen clone(), aber Fehlermeldung wg. fehlender Try-Catch

    System.out.println("Original : " + original);
    System.out.println("Klon     : " + cloned);

    original.left.add(new Complex(2,2));

    System.out.println("Original : " + original);
    System.out.println("Klon     : " + cloned);
  }

}

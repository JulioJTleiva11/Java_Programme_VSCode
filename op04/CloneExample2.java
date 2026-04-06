package op04;
/**
 * 2nd Example to demonstrate the effects of cloning. 
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class CloneExample2 implements Cloneable {
  public Complex left;
  public Complex right; // two complex numbers

  // Constructor
  public CloneExample2() {
    left = new Complex(1,0);
    right = new Complex(0,1);
  }

  @Override
  public String toString() {
    return "L : (" + left.getReal() + "," + left.getImaginary()
      +  ") R : (" + right.getReal() + ","  + right.getImaginary()
      +  ")";
  }
  
  @Override
  public CloneExample2 clone() { // deep copy!
    try { // always call super.clone() first! 
      CloneExample2 cloned 
        = (CloneExample2) super.clone(); // cast needed!

      // construct deep copies of left and right
      cloned.left // deep copy of left
        = new Complex(left.getReal(),
                      left.getImaginary());
      cloned.right // deep copy of right
        = new Complex(right.getReal(),
                      right.getImaginary());
      return cloned;
    } catch (CloneNotSupportedException e) {
      return null; // should not occur...
    }
  }

  /**
   * Show the effects of cloning.
   * @param args not used here
   */
  public static void main(String[] args) {
    CloneExample2 original = new CloneExample2();
    CloneExample2 cloned = original.clone();

    System.out.println("Original : " + original);
    System.out.println("Klon     : " + cloned);

    original.left.add(new Complex(2,2));

    System.out.println("Original : " + original);
    System.out.println("Klon     : " + cloned);
  }

}

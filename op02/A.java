package op02;

/**
 * Example for using inner classes.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class A {
  public static int x = 42;
  public int y;

  public A() { 
    this.y = x++; 
  }

  public class B {
    public int z;

    public B() { 
      this.z = y * x;
    }
  } // end of B

  public static void main(String[] args) {
    A a = new A();
    A.B b = a.new B(); // Watch the syntax!
    System.out.println("a.y : " + a.y + " b.z : " + b.z);
  }
} // end of A

package op02.innerclasses;

public class A {
  private int x =42;
  
  public void m() {
    final int y = 13;
    int z = 7;
    
    class B {
      private int a = x*y;
      
    }
    
    //return new B(); ///falls public Object m() {...}
  }
}

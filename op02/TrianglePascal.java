package op02;

/**
 * Example how to use 2D arrays.
 * 
 * <p>Adaption of class Dreieck from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class TrianglePascal {
  /**
   * Constructs a 2-dimensional array.
   * @param args not used here
   */
  public static void main(String[] args) {
    int[][] x = {
        { 1 }, 
        { 1, 2 }, 
        { 1, 2, 3 }, 
        { 1, 2, 3, 4 },
        { 1, 2, 3, 4, 5 } };  //PascalDreieck
                                                //Wichtig2DimArray
    for (int i = 0; i < x.length; i++) {          //Spalten x.length
      for (int j = 0; j < x[i].length; j++) {     //Zeilen x[i].length
        System.out.print(x[i][j]+" ");
      }
      System.out.println();
    }

    // Using for-each
    for (int[] a : x) { // loop element is 1D array     Spalten  x.length
      for (int b : a) { // loop element is int          Zeilen   x[i].length
        System.out.print(b+" ");
      }
      System.out.println();
    }
  }
}



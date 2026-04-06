package op02;

/**
 * Example how to use arrays in Java.
 * 
 * <p>Adaption of class ArrayTest1 from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class ArrayExample {
  /**
   * Defines some arrays and prints them.
   * @param args not used here
   */
  public static void main(String[] args) {
    int[] numbers = new int[10];
    // set numbers somehow
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i * 100;
    }
    // print number array
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + "\n");
    }
    System.out.println();

    // now an array of Strings
    String[] days = { "Mo", "Di", "Mi", "Do", 
        "Fr", "Sa", "So" };
    for (int i = 0; i < days.length; i++) {
      System.out.print(days[i] + " \n");
    }
    System.out.println();
  }
}

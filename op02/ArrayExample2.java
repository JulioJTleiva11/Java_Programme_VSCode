package op02;

/**
 * Example how to use arrays in Java.
 * 
 * <p>Adaption of class ArrayTest2 from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class ArrayExample2 {
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
    // for all numbers in array: with For Each Schleife
    for (int someNumber : numbers) {
      System.out.print(someNumber + " ");
    }
    System.out.println();

    // now an array of Strings with For Each Schleife
    String[] days = { "Mo", "Di", "Mi", "Do", 
        "Fr", "Sa", "So" };
    // for all strings in array:
    for (String someDay : days) {
      System.out.print(someDay + " ");
    }
    System.out.println();
  } 
} 
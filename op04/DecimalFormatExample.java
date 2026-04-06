package op04;
import java.text.DecimalFormat;

/**
 * Example how to use DecimalFormat.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class DecimalFormatExample {
  /**
   * Prints some numbers using various formatting patterns. 
   * @param args not used here
   */
  public static void main(String[] args) {

    // some values to be formatted
    double[] values = { 1.0, 123456.789012, -47.11, 1000000000 };

    // some formatting patterns
    DecimalFormat[] decFormats = new DecimalFormat[] {
        new DecimalFormat("###,##0.00###"),
        new DecimalFormat("##0000.0000#"),
        // \u20AC : UniCode of the Euro symbol
        new DecimalFormat("\u20AC###,##0.00"),
        new DecimalFormat("0.00 %"),
        new DecimalFormat("0.0#####E0"),
        new DecimalFormat("0.0")
        };

    for (double value : values) {
      for (DecimalFormat decFormat : decFormats) {
        String formatted = decFormat.format(value);
        System.out.println("F: " + formatted);
      }
      System.out.println(); // newline
    }
  }
}

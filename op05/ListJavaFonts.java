package op05;
import java.awt.GraphicsEnvironment;

/**
 * Lists all available fonts on the given system.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class ListJavaFonts {
  /**
   * Prints all available fonts.
   * 
   * @param args
   *          not used here
   */
  public static void main(String[] args) {
    // get all fontnames from the system
	String[] fonts = 
    		GraphicsEnvironment
    		.getLocalGraphicsEnvironment()
    		.getAvailableFontFamilyNames();
    // show these names
    for (String fontname : fonts) {
      System.out.println(fontname);
    }
    System.out.println("Anzahl Fonts: "+fonts.length);
  }
}

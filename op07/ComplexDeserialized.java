package op07;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Simple example to demonstrate deserialization(also Daten wieder einlesen?).
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class ComplexDeserialized {

  private static final 
    String fileName = ComplexConstants.getFilename();

  /**
   * Tries to read an array of serialized complex numbers. 
   * @param args not used here
   * @throws IOException if an IO error happens 
   * @throws ClassNotFoundException if the class that is 
   *     found in the file is not known.
   */
  public static void main(String[] args) 
      throws ClassNotFoundException, IOException {
    ComplexSerialized[] comArray = null;

    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(
          new FileInputStream(fileName));
      // read a single array object
      comArray = (ComplexSerialized[]) 
          in.readObject(); // throws exception 
                           // if class does not fit
                           // to this cast
    } finally { // in all cases close infile
      if (in != null) {
        in.close();
      }
    }
    // and now print the array found in the file
    for (ComplexSerialized c : comArray) {
      System.out.println(c);
    }
    System.out.println(" Anzahl : " +comArray.length);
  }
} 




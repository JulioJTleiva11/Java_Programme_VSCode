package op07;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Simple example to demonstrate serialization
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class ComplexSerialized implements Serializable { // 
  private double re; 
  private double im;

  private static final 
    int MAX = ComplexConstants.getMax(); //siehe complexConstants.java
  private static final 
    String fileName = ComplexConstants.getFilename();
  
  public ComplexSerialized(double re, double im) {
    this.re = re;
    this.im = im;
  }
  
  /**
   * Creates an array of complex numbers and writes it 
   * to a file.
   * @param args not used here 
   * @throws IOException in case of an I/O error
   */
  public static void main(String[] args) throws IOException {
    ComplexSerialized[] comArray 
                        = new ComplexSerialized[MAX];

    for (int i = 0; i < comArray.length;i++) {
      comArray[i] = new ComplexSerialized(MAX-i,i);
    }

    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(
          new FileOutputStream(fileName));
      out.writeObject(comArray); // writes array object 
      out.flush();
      out.close();
    } catch (IOException ioe) { 
      if (out != null) {
        out.close();
      }
    }
    for (ComplexSerialized c : comArray) {
      System.out.println(c);
    }
  }

  @Override
  public String toString() { 
    return re + " +i*" + im; 
  }
} 
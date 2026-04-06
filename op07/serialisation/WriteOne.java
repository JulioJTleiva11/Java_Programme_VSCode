package op07.serialisation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteOne {
  public static void main(String[] args) {
    Comp test = new Comp(4,3);

    ObjectOutputStream out = null;

    try {
      out = new ObjectOutputStream(
          new FileOutputStream("UIDtest"));
      out.writeObject(test);
      System.out.println("Geschrieben : " + test);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } finally {
      if (out != null) {
        try {
          out.flush();
          out.close();
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
      }
    }
  }
}

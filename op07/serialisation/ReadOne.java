package op07.serialisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadOne {
  
  public static void main(String[] args) {
    ObjectInputStream in = null;

    try {
      in = new ObjectInputStream(
          new FileInputStream("UIDtest"));
      Comp test = (Comp) in.readObject();
      System.out.println("Gelesen : " + test);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println("Die Klasse passt nicht!");
      e.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
      }
    }
  }
}


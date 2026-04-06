package op07;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File information retriever.
 * 
 * <p>Adaption of class FileInfo from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class FileInfo {
  /**
   * Applies all useful methods to a file. 
   * @param args first argument is the file to analyse.
   */
  public static void main(String[] args) {
    File file = new File(args[0]);
    System.out.println("Name: " + file.getName());
    System.out.println("Path: " + file.getPath());
    System.out.println("AbsolutePath: " 
                       + file.getAbsolutePath());   //absolutePath so viel umweg
    try {
      System.out.println("CanonicalPath: " 
                         + file.getCanonicalPath());  // canon=standardweg (direkter weg zu datei)
    } catch (IOException e) { // IO errors may occur
      e.printStackTrace();
    }
    System.out.println("Parent: " + file.getParent()); //alles von working directory, ein Teil vom Pfad, wo die File ist
    System.out.println("exists: " + file.exists());  //methode exist, existi. auf dem ROM? um nicht zu überschreiben.
    System.out.println("canRead: " + file.canRead());  //rechte: lesen
    System.out.println("canWrite: " + file.canWrite());
    System.out.println("isFile: " + file.isFile()); //rechte: ist das ein File
    System.out.println("isDirectory: " + file.isDirectory());//rechte: ist das ein Verzeichnis
    System.out.println("isAbsolute: " + file.isAbsolute());
    System.out.println("length: " + file.length());
    System.out.println("lastModified: " 
                       + new Date(file.lastModified()));
  }
}

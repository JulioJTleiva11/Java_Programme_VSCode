package op07;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Buffered file encoder using Caesar's cipher.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class CaesarBuffered {
  /**
   * Encodes a text file using Caesar's method. 
   * @param args inFilename outFilename offset
   * @throws IOException in case that some IO ops fail
   */
  public static void main(String[] args) 
      throws IOException {
    BufferedInputStream  in  = null;
    BufferedOutputStream out = null;

    // checking correctness of arguments first
    if (args.length < 3) {
      System.out.println("Args : FileIn FileOut Code");
      System.exit(0);
    }
    try {
      // the following three commands may throw exceptions
      in  = new BufferedInputStream(
          new FileInputStream(args[0]));
      out = new BufferedOutputStream(
          new FileOutputStream(args[1]));
      int coding = Integer.parseInt(args[2]);

      // no exception? All arguments are fine!
      int readByte;
      int encodedByte;
      do {
        readByte = in.read();
        if (readByte != -1) { // file not finished
          // encode the read byte by adding a number 
          // %256 needed to handle results >255
          encodedByte = (readByte + coding) % 256;
          out.write(encodedByte); // write it to out file
        }
      } while (readByte != -1); // until file is finished
    } finally { // if there is an exception or not
      try { 
        // close infile
        if (in != null) {
          in.close();
        }
        // close outfile
        if (out != null) {
          out.flush(); // flush before close
          out.close();
        }
      } catch (IOException e) {
        ; // oops, but we cannot do anything here.
      }
    }
  }
}

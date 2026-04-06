package op07;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * File encoder with various charsets using Caesar's cipher.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class CaesarCharset {
  /**
   * Encodes a text file using Caesar's method. 
   * @param args inFilename outFilename offset
   * @throws IOException in case that some IO ops fail
   */
  public static void main(String[] args) 
      throws IOException {
    InputStreamReader  in  = null;
    OutputStreamWriter out = null;

    // checking correctness of arguments first
    if (args.length < 3) {
      System.out.println("Args : FileIn FileOut Code");
      System.exit(0);
    }
    try {
      // the following three commands may throw exceptions
      in  = new InputStreamReader(
          new FileInputStream(args[0]));
      out = new OutputStreamWriter(
          new FileOutputStream(args[1]),
          "UTF-8"); // watch this!
      int coding = Integer.parseInt(args[2]);

      // no exception? All arguments are fine!
      int readChar;
      int encodedChar;
      do {
        readChar = in.read();
        if (readChar != -1) { // file not finished
            // encode the read byte by adding a number 
            // %2^16 needed to handle results >2^16
          encodedChar = (readChar + coding) % 65536; 
          out.write(encodedChar); // write it to out file
        }
      } while (readChar != -1); // until file is finished
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

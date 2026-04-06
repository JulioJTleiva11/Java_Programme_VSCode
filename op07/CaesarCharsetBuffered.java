package op07;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Buffered file encoder with charsets using Caesar's cipher.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class CaesarCharsetBuffered {
  /**
   * Encodes a text file using Caesar's method. 
   * @param args inFilename outFilename offset
   * @throws IOException in case that some IO ops fail
   */
  public static void main(String[] args) 
      throws IOException {
    BufferedReader  in  = null;
    BufferedWriter out = null;

    // checking correctness of arguments first
    if (args.length < 3) {
      System.out.println("Args : FileIn FileOut Code");
      System.exit(0);
    }
    try {
      // the following three lines may throw exceptions
      in  = new BufferedReader(
          new InputStreamReader(
              new FileInputStream(args[0])));
      out = new BufferedWriter(
          new OutputStreamWriter(
              new FileOutputStream(args[1]),
              "UTF-8")); // watch this!
      int coding = Integer.parseInt(args[2]);

      // no exception? All arguments are fine!
      int readByte;
      int encodedByte;
      do {
        readByte = in.read();
        if (readByte != -1) { // file not finished
          encodedByte = (readByte + coding) % 65536; // encode
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

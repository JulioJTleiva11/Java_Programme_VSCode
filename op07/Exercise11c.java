package op07;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise11c {

  public static void main(String[] args) 
      throws IOException {
    FileInputStream  in  = null;
    FileOutputStream out = null;

    int[] frequencies = new int[256];

    // checking correctness of arguments first
    if (args.length < 1) {
      System.out.println("Arguments : FileIn");
      System.exit(0);
    }
    try {
      // the following three lines may throw exceptions
      in  = new FileInputStream(args[0]);

      // no exception? All arguments are fine!
      int readByte;
      do {
        readByte = in.read();
        if (readByte != -1) { // file not finished
          frequencies[readByte]++;
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

      for (int i=0; i<frequencies.length; i++) {
        if (frequencies[i]>0)
          System.out.println(" Byte "+i+ " " +(char)(i)+ " : "+frequencies[i]);
      }
    }
  }
}


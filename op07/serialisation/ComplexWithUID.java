
package op07.serialisation;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;


public class ComplexWithUID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double re;
	private double im;
	private String uselessText;

	//private double distance;
	//private String usefulText;

	public ComplexWithUID (double re, double im) {
		this.re = re;
		this.im = im;
		this.uselessText = "Useless";
		
		//this.distance = Math.sqrt(re*re+im*im);
	}



	public String toString() {
		return "("+re+","+im+"," +uselessText+")";
		// return "("+re+","+im+"," +uselessText+","+distance+"," +usefulText + ")";
		// return "("+re+"," +uselessText+","+distance+"," +usefulText + ")";
	}	


	private static final String filename = "serialized-data.dat";
	private static Random rnd = new Random();

	public static Vector<ComplexWithUID> readData (String fname) {
		ObjectInputStream in = null;
		Vector<ComplexWithUID> result = new Vector<ComplexWithUID>();
		try {
			in = new ObjectInputStream(
					new FileInputStream(fname));
			boolean stop = false;
			do {
				try {
					Object next = in.readObject();
					System.out.println("Gelesen : " + next);
					if (next !=null && next instanceof ComplexWithUID) {
						result.add((ComplexWithUID) next);
					} else {
						stop = true;
					}
				} catch (ClassNotFoundException e) {
					stop = true;
					e.printStackTrace();
				}
			} while (!stop);

			in.close();
			return result;
		} catch (InvalidClassException ice) {
			System.out.println("Die Objekte passen nicht");
		} catch (EOFException e) {
			System.out.println("Die Datei ist ausgelesen");
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		return result;

	}

	public static void writeData(int number) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
					new FileOutputStream(filename));
			for (int i=0; i<number; i++) {
				ComplexWithUID next = new ComplexWithUID(rnd.nextInt(100),rnd.nextInt(100));
				System.out.println(" "+ i + ". Zahl : " + next);
				out.writeObject(next); // writes array object
			}
			out.flush();
			out.close();
		} catch (IOException ioe) { 
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		boolean write = false;

		if (write) {
			ComplexWithUID.writeData(5);
		} else {
			// read written data
			Vector<ComplexWithUID> data = ComplexWithUID.readData(filename);

			if (data!=null) {
				for (ComplexWithUID number : data) {
					System.out.println(number);
				}
			} else {
				System.out.println(" Keine Daten eingelesen");
			}
		}
	}
}

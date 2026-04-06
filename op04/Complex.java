package op04;
import java.util.Arrays;

/**
 * Complex numbers. 
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class Complex implements Comparable<Complex> {   //1.implements Comparable<Complex>
  private double re;
  private double im;
  private double angle;
  private double distance;


  private void cart2polar() {
    distance = Math.sqrt(re * re + im * im); //betrag bilden
    angle = Math.atan2(im,re); //winkeln errechnen.
  }

  private void polar2cart() {
    re = Math.cos(angle) * distance;
    im = Math.sin(angle) * distance;
  }

  /**
   * Constructor with cartesian coordinates.
   * @param re real part
   * @param im imaginary part
   */
  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
    cart2polar(); 
  }

  public double getReal() { 
    return re; 
  }

  public double getImaginary() { 
    return im; 
  }

  public double getAngle() { 
    return angle; 
  }

  public double getDistance() { 
    return distance; 
  }


  /**
   * Add a complex number.
   * @param z the number to add
   */
  public void add(Complex z) {
    re += z.re;
    im += z.im;
    cart2polar();
  }

  /**
   * Multiply with a complex number.
   * @param z the number to multiply with
   */
  public void multiply(Complex z) {
    double oldre = re;
    re = re * z.re - im * z.im;
    im = oldre * z.im + im * z.re;
    cart2polar();
  }

  /**
   * Computes the kth nth root.
   * @param n the nth root (n>=1)
   * @param k selects which of the n many nth roots (1<=k<=n)
   */
  public void root(int n, int k) {
    distance = Math.pow(distance, 1.0 / n); // dist^(1/n)
    angle /= n;
    angle += Math.PI * 2 / n * (k - 1);
    polar2cart();
  }

  /**
   * Computes the first nth root. 
   * @param n the nth root (n>=1)
   */
  public void root(int n) { 
    root(n,1); 
  }

  /**
   * Computes the nth power of the complex number. 
   * @param n the power (n>=1)
   */
  public void pow(int n) {
    distance = Math.pow(distance, n); 
    angle *= n;
    polar2cart();
  }


  /**
   * Print the number to out.
   */
  public void print() {
    if (im > 0) {
      System.out.println(re + "+" + im + "*i");
    } else {
      System.out.println(re + "-" + (-im) + "*i");
    }  
  }

  /**
   * Changes the number according to the given polar coordinates.
   * @param angle the angle of the number
   * @param distance the number's distance from the origin 
   */
  public void setPolar(double angle, double distance) {
    this.angle = angle;
    this.distance = distance;
    polar2cart();
  }


  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(Complex another) { //2.zuerst programmieren public int compareTo(Complex another) 
    if (re < another.re) {
      return -1;
    }
    if (re > another.re) {
      return 1;
    }
    else {
      return (int)(im - another.im);
    }
  }

  public String toString() {
    return re + " + i*" + im;
  }
  
  /**
   * Creates an array of complex numbers and sorts it.                 WICHTIGsort()
   * complex ist eine Klasse, und sort() kann nur primitiven Datentypen sortieren
   * also merken die "Vorgehensweise"
   * 1. implements Comparable<Complex>{}
   * 2. Methode mit Quickfix implementieren compareTo
   * @param args not used here
   */
  public static void main(String[] args) {
    Complex[] comArray = new Complex[16];

    for (int i = 0; i < comArray.length;i++) { //zähler i läuft von 0 auf 15
      comArray[i] = new Complex(i / 4,i % 4); //realTeil ist i/4 und imaginärTeil ist i%4 also der Rest
    }

    Arrays.sort(comArray); // Sorted by one command!   //3. nachdem man zuerst compareTo(Complex another) programmiert wurde

    for (Complex c : comArray) {
      System.out.println(c);
    }
  }
}


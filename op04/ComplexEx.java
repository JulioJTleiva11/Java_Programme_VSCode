package op04;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Complex numbers extended by Comparators.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class ComplexEx {
  private double re;
  private double im;
  private double angle;
  private double distance;

  //Methods: berechnung...
  private void cart2polar() {
    distance = Math.sqrt(re * re + im * im);
    angle = Math.atan2(im,re);//Returns the angle theta from the conversion of rectangular coordinates (x, y) 
                              //to polar coordinates (r, theta)
  }

  //Methods: berechnung re und im
  private void polar2cart() { //polar zu kartisian Koordinates
    re = Math.cos(angle) * distance;
    im = Math.sin(angle) * distance;
  }

  /**
   * Constructor with cartesian coordinates.
   * @param re real part
   * @param im imaginary part
   */
  public ComplexEx(double re, double im) {
    this.re = re;
    this.im = im;
    cart2polar(); //kartisian zu Polar umrechnung
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
  public void add(ComplexEx z) {
    re += z.re;
    im += z.im;
    cart2polar();//kartesian zu Polar umrechnung
  }

  /**
   * Multiply with a complex number.
   * @param z the number to multiply with
   */
  public void multiply(ComplexEx z) {
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

  public String toString() { 
    return re + " +i*" + im + " dist: " 
        + distance + " angle: " + angle; 
  }

  //hier wird nach jedem Muster eingeordnet: WICHTIGsort()nachMehrerenMuster
  // Ordered by real part first
  public static final Comparator<ComplexEx> 
  BY_REAL = new Comparator<ComplexEx>() {
    public int compare(ComplexEx a, ComplexEx b) {
      if (a.re < b.re) return -1;
      if (a.re > b.re) return 1;
      else return (int)Math.signum(a.im-b.im);
    }
  };

  // Ordered by imaginary part first
  public static final Comparator<ComplexEx> 
  BY_IMAG = new Comparator<ComplexEx>() {
    public int compare(ComplexEx a, ComplexEx b) {
      if (a.im < b.im) return -1;
      if (a.im > b.im) return 1;
      else return (int)Math.signum(a.re-b.re);
    }
  };

  // Ordered by distance (only!)
  public static final Comparator<ComplexEx> 
  BY_DIST = new Comparator<ComplexEx>() {
    public int compare(ComplexEx a, ComplexEx b) {
      double diff =a.distance - b.distance;
      return (int) Math.signum(diff);
    }
  };

  // Ordered by angle (only!)
  public static final Comparator<ComplexEx> 
  BY_ANGL = new Comparator<ComplexEx>() {
    public int compare(ComplexEx a, ComplexEx b) {
      double diff =a.angle - b.angle;
      return (int) Math.signum(diff);
    } 
  };

  /**
   * Creates an array of complex numbers and sorts it. 
   * @param args not used here
   */
  public static void main(String[] args) {
    ComplexEx[] comArray = new ComplexEx[16];

    for (int i = 0; i < comArray.length;i++) {
      comArray[i] = new ComplexEx(i / 4,i % 4);
    }
    System.out.println("Nach Realteil sortieren");
    Arrays.sort(comArray,BY_REAL); // A single line!
    for (ComplexEx c : comArray) System.out.println(c);

    System.out.println("Nach Imaginärteil sortieren");
    Arrays.sort(comArray,BY_IMAG); // A single line!
    for (ComplexEx c : comArray) System.out.println(c);

    System.out.println("Nach Betrag sortieren");
    Arrays.sort(comArray,BY_DIST); // A single line!
    for (ComplexEx c : comArray) System.out.println(c);

    System.out.println("Nach Winkel sortieren");
    Arrays.sort(comArray,BY_ANGL); // A single line!
    for (ComplexEx c : comArray) System.out.println(c);
  }
}


package op07.serialisation;

import java.io.Serializable;

public class Comp implements Serializable {


  private static final long serialVersionUID = 2L;

  private double re;
  private double im;


  private double angle;
  private double length;


  public Comp(double re, double im) {
    this.re = re;
    this.im = im;

    angle = Math.atan2(im,re);
    length = Math.sqrt(re * re + im * im);

  }

  public double getLength() {
    return length;
    //return Math.sqrt(re*re+im*im);
  }

  public double getAngle() {
    return angle;
    // return Math.atan2(im,re);
  }

  public String toString() {
    return "(" + re + "," + im + ") mit Betrag "
        + getLength() + " und Winkel " + getAngle();
  }

}

package op02;
/**
 * Rectangle, a 2d geometric object.
 * 
 * <p>Adaption of class Rechteck from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class Rectangle implements Geo {
  //Attribute
  private double width;
  private double height;

  //konstruktor
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  // we have to implement this method because
  // we stated that we "implement Geo" which
  // requires this method. 
  @Override
  public double getArea() {
    return width * height;
  }
}

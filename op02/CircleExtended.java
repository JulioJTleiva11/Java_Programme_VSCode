package op02;

/**
 * Extended Circle, a 2d geometric object.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class CircleExtended implements GeoExtended {

  private double radius;
  private static final double PI = 3.14159;

  public CircleExtended(double radius) {
    this.radius = radius;
  }

  @Override
  public double getHeight() {
    return 2 * radius;
  }

  @Override
  public double getWidth() {
    return 2 * radius;
  }

  @Override
  public double getArea() {
    return PI * radius * radius; // return Math.PI*radius*radius;
  }
}

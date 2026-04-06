package op02;

/**
 * Circle, a 2d geometric object.
 * 
 * <p>Adaption of class Kreis from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class Circle implements Geo {
  private double radius;
  private static final double PI = 3.14159; //oder einfach radius*radius*Math.PI; unten in Return der fkt getArea 

  //Konstruktor
  public Circle(double radius) {
    this.radius = radius;
  }

  // we have to implement this method because
  // we stated that we "implement Geo" which
  // requires this method. 
  @Override
  public double getArea() {
    return PI * radius * radius; //return radius*radius*Math.PI; dann ohne->private static final double PI = 3.14159;
  }
}
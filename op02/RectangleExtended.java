package op02;

/**
 * Extended Rectangle, a 2d geometric object.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class RectangleExtended implements GeoExtended {
  //attribute
  private double width;
  private double height;

  //konstruktor
  public RectangleExtended(double width, double height) {
    this.width = width;
    this.height = height;
  }
  //@override von Methode 
  @Override
  public double getHeight() {
    return height;
  }

  @Override
  public double getWidth() {
    return width;
  }
}

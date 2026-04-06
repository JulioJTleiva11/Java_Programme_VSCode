package op02;

/**
 * Extended interface for 2d geometric objects.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public interface GeoExtended {
  public double getHeight();

  public double getWidth();

  /**
   * Computes the area of the 2d object.
   * 
   * <p>Default implementation assumes a 
   * rectangular object
   * @return area of this 2d Geo object
   */
  default public double getArea() {
    return getHeight() * getWidth();
  }
}

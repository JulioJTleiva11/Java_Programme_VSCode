package op02;

/**
 * Example how to use interface Geo.
 * 
 * <p>Adaption of class GeoTest from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class GeoExample {
  /**
   * Creates two Geo objects and computes their area.
   * @param args not used here
   */
  public static void main(String[] args) {
    Geo rec = new Rectangle(10.5, 4.799); 
    Geo cir = new Circle(4.0049);

    //normale Darstellung
    System.out.println(rec.getArea()); 
    System.out.println(cir.getArea());

    //array_Darstellung als 2DimArray implementiert
    Geo twoDimObjects [] = new Geo[2];
    twoDimObjects[0] = cir;
    twoDimObjects[1] = rec;

    for(int i = 0; i < 2; i++){
      System.out.println("hier ist die Array" + i + ": " + twoDimObjects[i].getArea()); //mit index twoDimObjects[i]
    }

  }
}

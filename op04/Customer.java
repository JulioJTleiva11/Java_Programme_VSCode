package op04;
/**
 * Einfache KundenKlasse.
 *   
 * @author Henning Dierks
 * @version 1.0
 */

public class Customer {
  // Attributes
  private String name;
  private String address;

  // Constructors
  public Customer() { //StandardKonstruktor
  }

  public Customer(String name, String address) {
    this.name = name;
    this.address = address;
  }

  //
  public Customer(Customer other) {  // WichtigKonstruktorMitSelbemKlassenname
    this.name = other.name;
    this.address = other.address;
  }

  // Getters and Setters
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }
}


package op05;
import java.time.LocalDate;

/**
 * Members of our new club.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class Member {
  private static int nextNo = 0;
  private int number;
  private String name;
  private LocalDate memberSince;
  
  /**
   * Creates a new member and assigns an unique member 
   * number.
   * @param name of the new member
   * @param memberSince when the member joined the club
   */
  public Member(String name, LocalDate since) {
    this.number      = ++nextNo; // unique member numbers
    this.name        = name;
    this.memberSince = since;
  }
  
  // Getter
  public int getNumber() {
    return number;
  }
  
  public String getName() {
    return name;
  }
  
  public LocalDate getMemberSince() {
    return memberSince;
  }
}

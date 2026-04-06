package op02;

/**
 * Enumeration for grades.
 * 
 * <p>Adaption of class Note from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public enum Grade {
  SEHR_GUT(82, 90), 
  GUT(70, 81), 
  BEFRIEDIGEND(58, 69), 
  AUSREICHEND(46, 57), 
  MANGELHAFT(0, 45);

  private int from;
  private int to;

  // constructor
  private Grade(int from, int to) {
    this.from = from;
    this.to = to;
  }

  // get the range as String
  public String getRange() {
    return from + " - " + to;
  }

  /**
   * Computes the grade. 
   * @param points that have been achieved
   * @return grade that is achieved
   */
  public static Grade getGrade(int points) {
    for (Grade n : Grade.values()) {
      if (n.from <= points && points <= n.to) {
        return n;
      }
    }
    return GUT;
  }
}


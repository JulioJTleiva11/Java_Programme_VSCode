package op02;

/**
 * Class Student models student with matriculation number.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class Student {

  private static long nextMatriculationNo = 0; // STATIC !

  private static long newMatriculationNo() { // STATIC 
    nextMatriculationNo++;                   // METHOD !  
    return nextMatriculationNo;
    //return nextMatriculationNo++; //schneller
  }
  
  // not static
  private long matriculationNo;

  // Constructor
  public Student() { 
    matriculationNo = newMatriculationNo(); //Aufruf der staticMethode ohne THIS da staticMethode!!!
  }

  public long getMatriculationNo() { //getter von NICHT-STATIC Var
    return matriculationNo;
  }
  
  /**
   * Creates three students getting individual 
   * matriculation numbers.
   * @param args not used here
   */
  public static void main(String[] args) {
    Student a = new Student();
    Student b = new Student();
    Student c = new Student();
    System.out.println(a.getMatriculationNo() + " " + b.getMatriculationNo() + " " + c.getMatriculationNo());
  }
}

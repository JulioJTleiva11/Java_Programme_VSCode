package op02;

/**
 * Simple Example how to use a static inner class.
 * 
 * <p>Adaption of class AccountTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class UserExample {
  /**
   * Creates a dummy user and manipulates permissions.
   * @param args not used here
   */
  public static void main(String[] args) {
    User johnDoe = new User(4711);

    User.Permissions perm = johnDoe.getPermissions();
    perm.canRead = true;

    System.out.println(perm.canRead);
    System.out.println(perm.canWrite);
    System.out.println(perm.canDelete);
  }
}

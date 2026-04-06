package op02;

/**
 * A simple class for a user.
 * 
 * <p>Adaption of class Account from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class User {
  private int userId;
  private Permissions perm;
  
  //Konstruktor
  public User(int userId) {
    this.userId = userId;
    perm = new Permissions(); 
  }

  public int getUserId() {
    return userId;
  }

  // static inner class
  public static class Permissions {
    public boolean canRead;
    public boolean canWrite;
    public boolean canDelete;
  }

  public Permissions getPermissions() {
    return perm;
  }
}

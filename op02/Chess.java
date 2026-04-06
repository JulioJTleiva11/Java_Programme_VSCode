package op02;

/**
 * Example for a non-abstract subclass of Game.java.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class Chess extends Game {

  @Override
  public Board startGame() {
    //aufruf der Methode getBoard von Game, da extends Game
    //Board b = new ChessBoard(); //hier wird ChessBoard extra programmiert, also ein spezieller Fall von Bret->Schachtbret
    setBoard(new ChessBoard());  //pon una nueva tabla
    return getBoard();           //dame la nueva tabla
  }

  @Override
  public void makeMove(Board b) {
    // TODO Auto-generated method stub
  }

  @Override
  public Boolean isFinished(Board b) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void declareResult(Board b) {
    // TODO Auto-generated method stub
  }   

  /* kann man ueberschreiben, wenn noetig:
  @Override 
  public void play() { ... }
   */
}

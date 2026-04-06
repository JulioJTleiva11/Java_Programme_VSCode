package op02;

/**
 * Abstract class for standard 2-player board games.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public abstract class Game {
  private Board board;

  public Board getBoard() {
    return board;
  }

  public void setBoard(ChessBoard board) {
    this.board = board;
  }

// get a new board with starting position
  public abstract Board startGame();

  // make a legal move on given board (asks the user)
  public abstract void makeMove(Board b);

  // check whether the game is over
  public abstract Boolean isFinished(Board b);

  // prints the result 
  public abstract void declareResult(Board b);

  /**
   * If the abstract methods above are implemented 
   * correctly this method plays a game. 
   */
  public void play() {
    board = startGame(); // get an initialised board  
    do { // make a move as long as the game is not over
      makeMove(board); 
    } while (! isFinished(board)); 
    declareResult(board);
  }
}

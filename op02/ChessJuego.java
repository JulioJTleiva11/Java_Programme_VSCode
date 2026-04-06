package op02;

public class ChessJuego extends GameJuego { // chessAjedrez abgeleitet von Gamejuego(oberklasse)

    @Override
    public BoardJuego startGameJuego() {// will man ein brett zurückliefern
        //Todo Auto-generated method stub
        //throw new UnsupportedOperationException("unimplemented method 'makeMoveJuego'");

        // aqui se crea la nueva classe ChessBoardJuego() mit quick fix
        //BoardJuego t =  new ChessBoardJuego(); 
        //GameJuego hat das Attribute boardJuego
        setBoardJuego(new BoardJuego()); 
        return getBoardJuego();
    }

    @Override
    public void makeMoveJuego(BoardJuego t) {
        //Todo Auto-generated method stub
        throw new UnsupportedOperationException("unimplemented method 'makeMoveJuego'");
    }

    @Override
    public Boolean isFinishedJuego(BoardJuego t) {
        //Todo Auto-generated method stub
        throw new UnsupportedOperationException("unimplemented method 'makeMoveJuego'");
    }

    @Override
    public void declareResultJuego(BoardJuego t) {
        
    } 

}

package op02;

public abstract class GameJuego { //GameJuego hat das Attribute boardJuego
    //attribute
    private BoardJuego boardJuego;

    //getter and setters
    public BoardJuego getBoardJuego() {
        return boardJuego;
    }

    public void setBoardJuego(BoardJuego boardJuego) {
        this.boardJuego = boardJuego;
    }


    //abstract methoden: definieren für das Spiel, ohne sie zu programmieren/implementieren
    //crea nueva tabla con position start
    public abstract BoardJuego startGameJuego();  //comienza el juego

    //movimientos en la tabla de juego  
    public abstract void makeMoveJuego(BoardJuego t);  //has un movimiento en la tabla ->>void

    //cheka si termino el juego
    public abstract Boolean isFinishedJuego(BoardJuego t);  // se termino el juego? --->> Boolean  

    //print el resultado
    public abstract void declareResultJuego(BoardJuego t); // da el resultado 

    //in einer anderen Klasse werden die abstracte Methoden implementiert und hier unten 
    //wird Main implementiert, mit den schon implementierten abstracten Methoden aus der anderer Klasse
    
    public void playJuego (){   //hier nicht abstract sondern konkrett!
        boardJuego = startGameJuego();

        do {
            makeMoveJuego(boardJuego);
        } while (!isFinishedJuego(boardJuego));
        declareResultJuego(boardJuego);
    }


}

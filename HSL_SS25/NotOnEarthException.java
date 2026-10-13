package HSL_SS25;

// Anf 16 extends RuntimeException und public NotOnEarthException(String message...
public class NotOnEarthException extends RuntimeException{ // Anf 16
    private static final long serialVersionUID = 1L;
   
    // Anf 17
    public NotOnEarthException(String message){ // Anf 17
        super(message);
    }
}

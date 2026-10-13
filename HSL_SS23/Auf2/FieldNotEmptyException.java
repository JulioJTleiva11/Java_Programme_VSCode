package HSL_SS23.Auf2;

public class FieldNotEmptyException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public FieldNotEmptyException (String message){
        super(message);
    }

}

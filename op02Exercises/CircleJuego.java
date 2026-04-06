package op02Exercises;

public class CircleJuego implements GeoJuego{
    private double radius;
    private static final double PI = 3.14159;

    //constructor   
    public CircleJuego (double radius){
        this.radius = radius;       
    }
    //fkt, die überschrieben wird, damit

    @Override
    public double getAreaJuego() {
        return radius * radius * PI;
    }
    
}

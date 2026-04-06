package op02Exercises;


public class CircleExtendedJuego implements GeoExtendedJuego{
    private double radius;
    private static final double PI = 3.14159;

    //konstruktor
    public CircleExtendedJuego(double radius) {
        this.radius = radius;
    }

    @Override
    public double getBreite() {
        return 2*radius;
    }

    @Override
    public double getHoehe() {
        return 2*radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    


}

package op02Exercises;

public interface GeoExtendedJuego {
    //2 abstrakte methoden
    public double getBreite(); 
    public double getHoehe();
    //1 abstrakte methode mit default damit die programmiert werden kann
    
    /**
     * @return
     */
    default public double getArea(){
        return getBreite() * getHoehe();
    }
}

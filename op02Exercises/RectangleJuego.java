package op02Exercises;

public class RectangleJuego implements GeoJuego{  //implementieren von GeoJuego interface
    //was brauche ich? Flächenberecnung: b*h
    //2 private double's für die Breite und Höhe
    private double width;
    private double height;

    //konstruktor 
    public RectangleJuego(double width, double height){
        this.width = width;
        this.height = height;
    }

    //hier wird das interface GeoJuego implementiert !!!
    // oben schreiben implements GeoJuego
    // seine abstrakten methode programmieren mit quick fix, return implementieren
    @Override
    public double getAreaJuego() {
            return height * width;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getArea'");
    }

  


}

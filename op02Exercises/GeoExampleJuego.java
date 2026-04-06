package op02Exercises;

public class GeoExampleJuego {
    
    public static void main (String [] args){
        //hier werden 2 Obejekte kreiert
        GeoJuego rectangle = new RectangleJuego(4, 4);
        GeoJuego circle = new CircleJuego(1);

        //beide objects berechnet und mit print auf die konsole gebracht
        System.out.println(rectangle.getAreaJuego());
        System.out.println(circle.getAreaJuego());
    }
}

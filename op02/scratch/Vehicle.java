package op02.scratch;

public class Vehicle {
    public static void kmToMiles (int km){
        System.out.println("oberklasse");
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.kmToMiles(10);        
    }
    
}

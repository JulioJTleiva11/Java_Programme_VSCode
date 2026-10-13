package HSL_SS25;

public class Airport extends GeoLocation{ //anf 5
    private String name; //anf 6

    //Anf 7
    public Airport(String name, double latitude, double longitude) {
        super(latitude, longitude);
        this.name = name;
    }

    //Anf 8
    public String getName() {
        return this.name;
    }
    

}

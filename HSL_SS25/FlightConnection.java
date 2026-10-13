package HSL_SS25;

public class FlightConnection implements Comparable{ //Auf 14...implements Comparable<FlightConnections>{...}
    //anf 9
    private Airport departure;
    private Airport destination;
    
    //anf 10
    public FlightConnection(Airport departure, Airport destination) {
        this.departure = departure;
        this.destination = destination;
    }

    //Anf 11
    public Airport getDeparture() {
        return this.departure;
    }

    //Anf 11
    public Airport getDestination() {
        return this.destination;
    }

    //Anf 12
    public double getDistanceKm(){
        return GeoLocation.distanceInKm(this.departure, this.destination);
    }

    //Anf 13
    @Override
    public String toString() {
        double distanz = this.getDistanceKm();
        //alternativ formatierung sosnt direkt distanz
        String distanzFormatiert = String.format("%.1f", distanz).replace('.', ',');
        return this.departure.getName() + " to " + this.destination.getName() + " ( " + distanzFormatiert + " km)";
    }
  
    //anf 15
    @Override
    public int compareTo(FlightConnection other) {
        double dieseDistanz = this.getDistanceKm();
        double andereDistanz = other.getDistanceKm();

        if(dieseDistanz < andereDistanz){
            return -1;//kürzerer Flug nach vorne
        }
        else if ( dieseDistanz > andereDistanz){
            return 1;//längerer Flug nach hinten
        }
        else {
            return 0;//Flüge sind gleich lang
        }
    }

    

}

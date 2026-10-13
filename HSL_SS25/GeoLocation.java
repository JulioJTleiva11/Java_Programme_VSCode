package HSL_SS25;


public class GeoLocation {
    //anf 1
    private double latitude;
    private double longitude;

    //Anf 2 Konstruktor
    public GeoLocation(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
        //Anf 18
        if (latitude < -90.0 || latitude > 90.0 || longitude < -180.0 || longitude > 180.0){
            //damit hier funktionier ist zu implementieren in der class NotOnEarthException EXTENDS RUNTIMEEXCEPTION!!! und eine Public method
            throw new NotOnEarthException("Koordinanten fehlerhaft! Breitengrad [-90,90], Längengrad [-180,180] beachten!");
        }
    }

    //Anf3
    public double getLatitude() {
        return latitude;
    }

    //Anf3
    public double getLongitude() {
        return longitude;
    }

    //Anf4
    public static double distanceInKm(GeoLocation a, GeoLocation b){
        double lat1 = Math.toRadians(a.getLatitude());
        double lon1 = Math.toRadians(a.getLongitude());
        double lat2 = Math.toRadians(b.getLatitude());
        double lon2 = Math.toRadians(b.getLongitude());

        double d = 6378.388 * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 -lon1));
        return d;
    }
}

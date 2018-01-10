package nom.googleapi.domain;

public class MapLocation {

    private final double latitude;
    private final double longitude;

    public MapLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String asString() {
        return latitude + "," + longitude;
    }

}

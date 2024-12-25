package Project.Refactoring;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double calculateDistance(Location thatLocation) {
        double latitudeDiff = Math.abs(this.latitude - thatLocation.latitude);
        double longitudeDiff = Math.abs(this.longitude - thatLocation.longitude);
        return Math.sqrt(latitudeDiff * latitudeDiff + longitudeDiff * longitudeDiff);
    }
}

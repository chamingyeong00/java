public class Location {
    private String city;
    private double latitude;
    private double longitude;

    public Location(String city, double latitude, double longitude){
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public String toString(){
        return city + ' ' + latitude + " " + longitude;
    }
}

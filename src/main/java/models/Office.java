package models;

public class Office {

    private String uniqueID;
    private String address;
    private int rating;

    public Office(String uniqueID, String address, int rating) {
        this.uniqueID = uniqueID;
        this.address = address;
        this.rating = rating;
    }

    public String getUniqueID() {
        return uniqueID;
    }
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public void setAddress(String address) {this.address = address;}

    public String getAddress() {return address;}

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



    @Override
    public String toString(){
        return " Office ID: " + uniqueID + " Address: " + address + " Office rating: " + rating;
    }
}

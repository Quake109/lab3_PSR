package models;

import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

import java.util.Map;

@Entity
public class Offer{

    @PartitionKey
    private Integer id;
    private String place;
    private String climate;
    private int rating;
    private Client client;
    private Office office;

    public Offer(Integer id, String place, String climate, int rating, Client client, Office office ){
        this.id = id;
        this.place = place;
        this.climate = climate;
        this.rating = rating;
        this.client = client;
        this.office = office;
    }

    public Offer() {

    }

    public int getId(){ return id; }

    public void setId(int id){ this.id = id; }

    public void setPlace(String place) {this.place = place;}

    public String getPlace() {return place;}

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Office getOffice(){
        return office;
    }

    public void setOffice(Office office){
        this.office = office;
    }


    @Override
    public String toString(){
        return "Offer: "+" Id: " + id + " Climate: " + climate + " Place: " + place + " Journey rating: " + rating + " Client: " + client + " Office: " + office;
    }


}

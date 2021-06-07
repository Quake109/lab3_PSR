package models;


public class Client {

    private String name;
    private String surname;
    private String pesel;
    private String phoneNumer;

    public Client(String name,String surname, String pesel, String phoneNumer) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.phoneNumer = phoneNumer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {this.surname = surname;}

    public String getSurname() {return surname;}

    public void setPesel(String pesel) {this.pesel = pesel;}

    public String getPesel() {return pesel;}

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    @Override
    public String toString(){
        return " Client: " + name + " " + surname + " Pesel: " + pesel + " Phone number: " + phoneNumer;
    }
}
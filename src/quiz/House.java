package quiz;

import java.util.ArrayList;

public class House {
    private int rooms;
    private int bathrooms;
    private int size;
    private double price;
    private boolean petFriendly;

    //CONSTRUCTOR
    public House(int rooms, int bathrooms, int size, double price, boolean pets){
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.size = size;
        this.price = price;
        this.petFriendly = pets;
    }

    //GETTERS
    public int getRooms() {
        return rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    //SETTERS
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPetUnfriendly() {
        this.petFriendly = false;
    }

    //METHODS
    public void demolish(){
        this.setRooms(0);
        this.setBathrooms(0);
        this.setSize(0);
        this.setPrice(0.0);
        this.setPetUnfriendly();
    }

    public double pricePerFoot(){
        return this.price / this.size;
    }

    public boolean safetyCheck(){
        if(this.getRooms() < 3 || this.getBathrooms() < 3){
            this.setPetUnfriendly();
        }
        if(this.getSize() / (this.getBathrooms() + this.getRooms()) < 100){
            this.demolish();
            return false;
        }
        return true;
    }

    public House houseChooser(double budget, boolean pets, ArrayList<House> options){
        House bestHouse = this;
        for(House house : options){
            if(house.getPrice() < budget){
                if(pets && !house.isPetFriendly()){
                    continue;
                }
                if(!house.safetyCheck()){
                    continue;
                }
                double house0 = bestHouse.pricePerFoot();
                double house1 = house.pricePerFoot();
                if(house0 > house1){
                    bestHouse = house;
                }
            }
        }
        return bestHouse;
    }

    public House splitRent(){
        if(safetyCheck()) {
            this.size /= 2;
            this.price /= 2;
            return new House(this.getSize(), this.getBathrooms(), this.getSize(), this.getPrice(), this.isPetFriendly());
        }
        return this;
    }
}

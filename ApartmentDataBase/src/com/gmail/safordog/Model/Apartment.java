package com.gmail.safordog.Model;

public class Apartment {

    private String areaOfCity;
    private String address;
    private double square;
    private int roomNumber;
    private int price;

    public Apartment() {
    }

    public Apartment(String areaOfCity, String address, double Square, int roomNumber, int price) {
        this.areaOfCity = areaOfCity;
        this.address = address;
        this.square = Square;
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public String getAreaOfCity() {
        return areaOfCity;
    }

    public void setAreaOfCity(String areaOfCity) {
        this.areaOfCity = areaOfCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double aquare) {
        this.square = aquare;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

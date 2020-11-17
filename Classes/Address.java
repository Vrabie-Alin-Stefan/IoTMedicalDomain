package com.example.lab6;

public class Address {
    private String Street;
    private int HouseNo;
    private String City;
    private String Country;

    public Address(String street, int houseNo, String city, String country) {
        Street = street;
        HouseNo = houseNo;
        City = city;
        Country = country;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(int houseNo) {
        HouseNo = houseNo;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}

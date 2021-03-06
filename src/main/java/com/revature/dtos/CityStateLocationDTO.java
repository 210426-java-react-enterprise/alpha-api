package com.revature.dtos;

public class CityStateLocationDTO {
    private String city;
    private String state;

    public CityStateLocationDTO(){
        super();
    }

    public CityStateLocationDTO(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

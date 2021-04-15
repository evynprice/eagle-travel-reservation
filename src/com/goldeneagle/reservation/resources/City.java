package com.goldeneagle.reservation.resources;


public class City {
    private final String name;
    private final String airport;

    public City(String name, String airport) {
        this.name = name;
        this.airport = airport;
    }

    public String getName() {
        return this.name;
    }

    public String getAirport() {
        return this.airport;
    }
}

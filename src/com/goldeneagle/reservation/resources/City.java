package com.goldeneagle.reservation.resources;

import java.util.ArrayList;
import java.util.List;

public class City {
    private final String name;
    private final String airportName;
    private List<Airport> airports;

    public City(String name) {
        this.name = name;
        this.airport = new ArrayList<>();
    }

    public City(String name, List<Airport> airports) {
        this.name = name;
        this.airports = airports;
    }

    public String getName() {
        return this.name;
    }

    public List<Airport> getAirportName() {
        return this.airports;
    }

    public void addAirport(Airport airport) {
        this.airports.add(airport);
    }
}

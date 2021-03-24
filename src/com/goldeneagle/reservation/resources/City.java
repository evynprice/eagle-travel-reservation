package com.goldeneagle.reservation.resources;

import java.util.ArrayList;
import java.util.List;

public class City {
    private final String name;
    private List<Flight> flights;

    public City(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    public City(String name, List<Flight> flights) {
        this.name = name;
        this.flights = flights;
    }

    public String getName() {
        return this.name;
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
}

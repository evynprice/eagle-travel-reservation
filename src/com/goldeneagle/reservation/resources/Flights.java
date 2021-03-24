package com.goldeneagle.reservation.resources;

import com.goldeneagle.reservation.resources.Flight;

import java.util.ArrayList;
import java.util.List;

public class Flights {
    private List<Flight> flights = new ArrayList<>();

    public Flights() {
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
}

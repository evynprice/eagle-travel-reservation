package com.goldeneagle.reservation.resources;

import java.util.Date;

public class Flight {
    private final String name;
    private final Date date;
    private final City departureCity;
    private final City arrivalCity;
    private final int totalSeats;
    private int availableSeats;

    public Flight(String name, Date date, City departureCity, City arrivalCity, int totalSeats) {
        this.name = name;
        this.date = date;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
}

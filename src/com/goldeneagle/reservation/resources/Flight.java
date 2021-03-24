package com.goldeneagle.reservation.resources;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight {
    private final String name;
    private final LocalDateTime dateTime;
    private final Duration duration;
    private final City departureCity;
    private final City arrivalCity;
    private final double cost;
    private final int totalSeats;
    private int availableSeats;

    public Flight(String name, LocalDateTime dateTime, Duration duration, City departureCity, City arrivalCity, double cost, int totalSeats) {
        this.name = name;
        this.dateTime = dateTime;
        this.duration = duration;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.cost = cost;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public City getDepartureCity() {
        return this.departureCity;
    }

    public City getArrivalCity() {
        return this.arrivalCity;
    }

    public double getCost() {
        return this.cost;
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public void takeSeat() {
        this.availableSeats -= 1;
    }
}

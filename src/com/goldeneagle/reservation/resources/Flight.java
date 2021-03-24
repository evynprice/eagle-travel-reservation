package com.goldeneagle.reservation.resources;

import java.time.Duration;
import java.time.LocalDate;

public class Flight {
    private final String name;
    private final LocalDate date;
    private final Duration duration;
    private final City departureCity;
    private final City arrivalCity;
    private final int totalSeats;
    private int availableSeats;

    public Flight(String name, LocalDate date, Duration duration, City departureCity, City arrivalCity, int totalSeats) {
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDate() {
        return this.date;
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

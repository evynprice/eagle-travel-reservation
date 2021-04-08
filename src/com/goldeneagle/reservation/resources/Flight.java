package com.goldeneagle.reservation.resources;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/*
 * Flight objects are the largest resource object and depend on both the City and Flight objects. They include
 * a name, flight number, departure city, arrival city, date, duration, price, and a list of seats
 */
public class Flight {
    private final String name;
    private final int num;
    private final City departureCity;
    private final City arrivalCity;
    private final LocalDateTime dateTime;
    private final Duration duration;
    private final double price;
    private List<Seat> seats;

    /**
     * Constructs a new Flight object. Because in this example all Flights will be hard coded, this constructor
     * is the only one necessary
     * @param name String flight company
     * @param num int aircraft identifier
     * @param departureCity City departureCity
     * @param arrivalCity City arrivalCity
     * @param dateTime LocalDate flight date
     * @param duration Duration flight duration
     * @param price double seat cost
     * @param seats List<Seat> list of seats
     */
    public Flight(String name, int num, City departureCity, City arrivalCity,
                  LocalDateTime dateTime, Duration duration, double price, List<Seat> seats) {
        this.name = name;
        this.num = num;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateTime = dateTime;
        this.duration = duration;
        this.price = price;
        this.seats = seats;
    }

    /**
     * Provides company name (Ex. Delta)
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns aircraft identifier (Ex. 1592)
     * @return num
     */
    public int getNum() {
        return this.num;
    }

    /**
     * Returns arrivalCity object
     * @return arrivalCity
     */
    public City getArrivalCity() {
        return arrivalCity;
    }

    /**
     * Provides departureCity object
     * @return departureCity
     */
    public City getDepartureCity() {
        return this.departureCity;
    }

    /**
     * Provides LocalDateTime flight date and time
     * @return date
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Provides flight duration
     * @return Duration
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Provides seat price
     * @return double price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Provides list of Seat objects
     * @return List<Seat> seats
     */
    public List<Seat> getSeats() {
        return seats;
    }

    /**
     * Set the flight seats
     * @param seats List of flight seats
     */
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}

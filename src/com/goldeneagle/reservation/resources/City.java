package com.goldeneagle.reservation.resources;

/*
 * Stores city and airport names.
 */
public class City {
    private final String name;
    private final String airport;

    /**
     * Takes in name and airport and stores them as instance variables
     * @param name
     * @param airport
     */
    public City(String name, String airport) {
        this.name = name;
        this.airport = airport;
    }

    /**
     * Provides the city name
     * @return name String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Provides the airport name
     * @return airport String
     */
    public String getAirport() {
        return this.airport;
    }
}

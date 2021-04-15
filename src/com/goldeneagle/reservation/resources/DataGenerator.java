/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldeneagle.reservation.resources;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class will be used to generate the random data used by the program. While in the real world the list of flights,
 * cities, and seats would be stored in a database, this project chooses to randomly select that data from a list of
 * possible options to maintain simplicity and focus on understanding.
 */
public class DataGenerator {
    // initialize instance variables
    private final List<City> cities = new ArrayList<>();
    private final List<Flight> flights = new ArrayList<>();
    private final List<LocalDateTime> dateTimes = new ArrayList<>();
    private final Random random = new Random();

    /**
     * The default constructor will call on private object methods in order to generate the data required
     */
    public DataGenerator() {
        this.generateCities();
        this.generateFlights(100); // generate six flights
    }

    /**
     * This method adds all of the possible cities for departures and arrivals to the cities object
     */
    private void generateCities() {
        this.cities.add(new City("Chattanooga, TN", "CHA"));
        this.cities.add(new City("Nashville, TN", "NSH"));
        this.cities.add(new City("Chicago, IL", "CHI"));
        this.cities.add(new City("Los Angeles, CA", "LOS"));
        this.cities.add(new City("Atlanta, GA", "ATL"));
    }

    /**
     * This method creates or uses random data to create flight objects and store them in the flights list.
     * @param flightCount number of flights to generate
     */
    private void generateFlights(int flightCount) {
        /*
        Data that needs to be generated:

        public Flight(String name, int num, City departureCity, City arrivalCity,
                  LocalDateTime dateTime, Duration duration, double price, List<Seat> seats)
         */

        // Create list of names to randomly pick from
        List<String> names = Arrays.asList("Delta", "American", "JetBlue", "Spirit", "United", "Allegiant");

        // create list of times starting with today's date and every day for the next 3 days
        LocalDateTime now = LocalDateTime.now(); // get today's time
        this.dateTimes.add(now); // initialize list with today

        // start with current date time and loop to add extra times

        for (int i = 1; i <= 3; i++) {
            int randomMinutes = this.random.nextInt(180); // create a random time between 0 and 180
            this.dateTimes.add(now.plusDays(i).plusMinutes(randomMinutes)); // add 1 day and the random minutes
        }


        /* For the requested number of flights, pull a random name from the list, generate a random flight number,
           pull random departure and arrival cities, date, duration, and generate seat list
         */
        for (int i = 0; i < flightCount; i++) {
            /* generate a random number between 0 and the last element in the list, then fetch the name that is in that
               position of the list
             */
            int nameIndex = this.random.nextInt(names.size());
            String flightName = names.get(nameIndex);

            // generate a random flight number
            int flightNum = this.generateFlightNum();

            /* generate a random number between 0 and the last element in the cities list, then grab the city that
               is in that element
             */
            int departureCityIndex = this.random.nextInt(this.cities.size());
            City departureCity = this.cities.get(departureCityIndex);

            // repeat for arrival city
            int arrivalCityIndex = this.random.nextInt(this.cities.size());
            City arrivalCity = this.cities.get(arrivalCityIndex);

            // if the destination and arrival are the same, pick a different arrival city
            while (arrivalCity.equals(departureCity)) {
                arrivalCityIndex = this.random.nextInt(this.cities.size());
                arrivalCity = this.cities.get(arrivalCityIndex);
            }

            // pick a number between 0 and the end of the date times list, then fetch the date time at that index
            int dateTimeIndex = this.random.nextInt(dateTimes.size());
            LocalDateTime dateTime = this.dateTimes.get(dateTimeIndex);

            // generate a duration between 30 minutes and 3 and a half hours
            Duration duration = this.generateDuration(30, 210);

            // generate the cost of the trip
            double price = this.generateCost();

            // generate list of seats
            List<Seat> seats = new ArrayList<>();

            for(int j=1; j <= 25; j++) {
                boolean available = this.random.nextBoolean();
                seats.add(new Seat(j + "", available));
            }

            // generate a new flight based on that information
            this.flights.add(new Flight(flightName, flightNum, departureCity, arrivalCity, dateTime, duration, price, seats));
        }

        // change some flights to have all seats full

        for (Flight flight : this.flights) {
            boolean random = this.random.nextBoolean();

            if (random) {
                for (Seat seat : flight.getSeats()) {
                    seat.setAvailable(false);
                }
            }
        }

    }

    /**
     * Generates a random cost for the flight
     * @return cost
     */
    public double generateCost(){
        return this.random.nextDouble() * 1000;
    }

    /**
     * Generates a random flight duration between passed in minimum duration and maximum duration in minutes
     * @param minDuration in minutes
     * @param maxDuration in minutes
     * @return Duration duration
     */
    public Duration generateDuration(int minDuration, int maxDuration) {
        Duration duration = Duration.ofMinutes(minDuration); // create a duration starting with the min value

        /*
        Randomly generate a time within the min and max values passed and set that to timeToAdd. Then add that
        time to the duration
        */
        int timeToAdd = random.nextInt(maxDuration - minDuration);
        duration = duration.plusMinutes(timeToAdd); //returns between (min, Max)

        return duration;
    }

    /**
     * Generates a random flight number between 1 and 1000
     * @return flightNum
     */
    public int generateFlightNum(){
        return random.nextInt(9999) + 1;
    }

    /**
     * Provides a list of cities
     * @return cities
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * Provides a list of flights
     * @return flights
     */
    public List<Flight> getFlights() {
        return flights;
    }

    public List<LocalDateTime> getDateTimes() {
        return dateTimes;
    }
}


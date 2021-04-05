/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldeneagle.reservation.resources;
import java.text.DecimalFormat;
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
    private final Random random = new Random();

    /**
     * The default constructor will call on private object methods in order to generate the data required
     */
    public DataGenerator() {
        this.generateCities();
        this.generateFlights(6); // generate six flights
    }

    /**
     * This method adds all of the possible cities for departures and arrivals to the cities object
     */
    private void generateCities() {
        this.cities.add(new City("Chattanooga, TN"));
        this.cities.add(new City("Nashville, TN"));
        this.cities.add(new City("Chicago, IL"));
        this.cities.add(new City("Los Angeles, CA"));
        this.cities.add(new City("Atlanta, GA"));
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
        List<LocalDateTime> dateTimes = new ArrayList<>();

        dateTimes.add(now); // initialize list with today


        // start with current date time and loop to addd extra times
        for(int i=1; i <= 3; i++) {
            dateTimes.add(now.plusDays(i));
        }

        // TODO: Create list of possible durations

        // TODO: generate seats

        /* For the requested number of flights, pull a random name from the list, generate a random flight number,
           pull random departure and arrival cities, date, duration, and seats list
         */
        for(int i=0; i < flightCount; i++) {
            /* generate a random number between 0 and the last element in the list, then fetch the name that is in that
               position of the list
             */
            int nameIndex = random.nextInt(names.size());
            String flightName = names.get(nameIndex);

            // generate a random flight number
            int flightNum = this.generateFlightNum();

            /* generate a random number between 0 and the last element in the cities list, then grab the city that
               is in that element
             */
            int departureCityIndex = random.nextInt(this.cities.size());
            City departureCity = this.cities.get(departureCityIndex);

            // repeat for arrival city
            int arrivalCityIndex = random.nextInt(this.cities.size());
            City arrivalCity = this.cities.get(arrivalCityIndex);

            // if the destination and arrival are the same, pick a different arrival city
            while (arrivalCity.equals(departureCity)) {
                arrivalCityIndex = random.nextInt(this.cities.size());
                arrivalCity = this.cities.get(arrivalCityIndex);
            }

            // pick a number between 0 and the end of the date times list, then fetch the date time at that index
            int dateTimeIndex = random.nextInt(dateTimes.size());
            LocalDateTime dateTime = dateTimes.get(dateTimeIndex);

            // generate the cost of the trip
            double price = this.generateCost();

            // generate a new flight based on that information
            this.flights.add(new Flight(flightName, flightNum, departureCity, arrivalCity, dateTime, null, price, null));
        }
    }

    /**
     * Generates a random cost for the flight
     * @return cost
     */
    public double generateCost(){
        Random rand = new Random();
        double cost = rand.nextDouble() * 1000;
        DecimalFormat df = new DecimalFormat("#.00");
        return  Double.valueOf(df.format(cost));
    }

    /**
     * Generates a random flight number between 1 and 1000
     * @return flightNum
     */
    public int generateFlightNum(){
        Random rands = new Random();
        int flightNum = rands.nextInt(9999) + 1;
        return flightNum;
    }
}


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
 *
 * @author Joeseph Jackson
 */
public class DataGenerator {
    private List<City> cities = new ArrayList<>();
    private List<Flight> flights = new ArrayList<>();
    private Random random = new Random();

    public DataGenerator() {

        // generate cities
        this.cities.add(new City("Chattanooga, TN"));
        this.cities.add(new City("Nashville, TN"));
        this.cities.add(new City("Chicago, IL"));
        this.cities.add(new City("Los Angeles, CA"));
        this.cities.add(new City("Atlanta, GA"));

        this.generateFlights();
    }

    private void generateFlights() {
        // newFlight(String name, int num, City departureCity, City arrivalCity,
        //                  LocalDateTime dateTime, Duration duration, double price, List<Seat> seats)

        final int flightCount = 6;

        List<String> names = Arrays.asList("Delta", "American", "JetBlue", "Spirit", "United", "Allegiant");

        LocalDateTime now = LocalDateTime.now();
        List<LocalDateTime> dateTimes = Arrays.asList(now);

        for(int i=1; i < 7; i++) {
            dateTimes.add(now.plusDays(i));
        }

        
        // generate duration
        // generate price
        // generate seats

        for(int i=0; i < flightCount; i++) {
            int nameIndex = random.nextInt(names.size());
            String flightName = names.get(nameIndex);

            // pick the random data
            int flightNum = this.generateFlightNum();

            int departureCityIndex = random.nextInt(this.cities.size());
            City departureCity = this.cities.get(departureCityIndex);

            int arrivalCityIndex = random.nextInt(this.cities.size());
            City arrivalCity = this.cities.get(arrivalCityIndex);

            while (arrivalCity.equals(departureCity)) {
                arrivalCityIndex = random.nextInt(this.cities.size());
                arrivalCity = this.cities.get(arrivalCityIndex);
            }

            int dateTimeIndex = random.nextInt(dateTimes.size()); // gives random time index
            LocalDateTime dateTime = dateTimes.get(dateTimeIndex);

            this.flights.add(new Flight(flightName, flightNum, departureCity, arrivalCity, dateTime, null, 0, null));
        }
    }


    // cannot complete untill a completed seats class is created.
//    public Seats[] generateSeats(){
//        return new Seats[10];
//    }
    
    public double generateCost(){
        Random rand = new Random();
        double cost = rand.nextDouble() * 1000;
        DecimalFormat df = new DecimalFormat("#.00");
        return  Double.valueOf(df.format(cost));
    }
    public int generateFlightNum(){
        Random rands = new Random();
        int flightNum = rands.nextInt(9999) + 1;
        return flightNum;
    }
    public int generateFlightTime(){
        return 0;
    }
    public String generateName(int flightNum, String departureCity, String arrivalCity){
        // Pieces of Flight Name: <Airline> <Flight Number> <Departure City> - <Arrival City>
        // Ex: United 5701 ATL-CHA
        
        // Flow
        // 1. Generate random Airline
        // 2. Construct name from airline, flight num, departure city, and arrival city
        return  null;
    }
}


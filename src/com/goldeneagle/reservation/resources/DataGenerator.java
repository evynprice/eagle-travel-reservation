/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldeneagle.reservation.resources;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author Joeseph Jackson
 */
public class DataGenerator {
    private List<City> cities;
    private List<Flight> flightList;
 
    public DataGenerator() {
        // generate cities
        this.cities.add(new City("Chattanooga, TN"));
        this.cities.add(new City("Nashville, TN"));
        this.cities.add(new City("Chicago, IL"));
        this.cities.add(new City("Los Angeles, CA"));
        this.cities.add(new City("Atlanta, GA"));
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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldeneagle.reservation.resources;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joeseph Jackson
 */
public class FlightTest {
    private String defaultFlightName;
    private City defaultDepartureCity;
    private City defaultArrivalCity;
    private Date defaultNow;
            
    public FlightTest() {
    }
    
    
    @Before
    public void setUp() {
        this.defaultFlightName = "United 5701 ATL-CHA";
        this.defaultDepartureCity = new City("Atlanta, GA");
        this.defaultArrivalCity = new City("Chattanooga, TN"); 
        this.defaultNow = new Date();         
    }
    
  
    /**
     * Test of getName method, of class Flight.
     */
    @Test
    public void testGetName() {
        Flight flightObj = new Flight(this.defaultFlightName, this.defaultNow, this.defaultDepartureCity, this.defaultArrivalCity, 75);
        String expResult = this.defaultFlightName;
        String result = flightObj.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class Flight.
     */
    @Test
    public void testGetDate() {
        Flight flightObj = new Flight(this.defaultFlightName, this.defaultNow, this.defaultDepartureCity, this.defaultArrivalCity, 75);
        Date expResult = this.defaultNow;
        Date result = flightObj.getDate();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getDepartureCity method, of class Flight.
     */
    @Test
    public void testGetDepartureCity() {
        Flight flightObj = new Flight(this.defaultFlightName, this.defaultNow, this.defaultDepartureCity, this.defaultArrivalCity, 75);
        City expResult = this.defaultDepartureCity;
        City result = flightObj.getDepartureCity();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getArrivalCity method, of class Flight.
     */
    @Test
    public void testGetArrivalCity() {
        Flight flightObj = new Flight(this.defaultFlightName, this.defaultNow, this.defaultDepartureCity, this.defaultArrivalCity, 75);
        City expResult = this.defaultArrivalCity;
        City result = flightObj.getArrivalCity();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getTotalSeats method, of class Flight.
     */
    @Test
    public void testGetTotalSeats() {
        Flight  flightObj = new Flight(this.defaultFlightName, this.defaultNow, this.defaultDepartureCity, this.defaultArrivalCity, 75);
        int expResult = 75;
        int result = flightObj.getTotalSeats();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getAvailableSeats method, of class Flight.
     */
    @Test
    public void testGetAvailableSeats() {
        Flight flightObj = new Flight(this.defaultFlightName, this.defaultNow, this.defaultDepartureCity, this.defaultArrivalCity, 75);
        int expResult = 75;
        int result = flightObj.getAvailableSeats();
        assertEquals(expResult, result);
    }
    /**
     * Testing the constructor of the Flight.java class sets the proper attributes.
     */
    @Test
    public void testAFlightObjectCanBeCreated()
    {
        Flight flightObj = new Flight(this.defaultFlightName, this.defaultNow, this.defaultDepartureCity, this.defaultArrivalCity, 75);
        assertEquals(flightObj.getName(), this.defaultFlightName);
        assertEquals(flightObj.getDate(), this.defaultNow);
        assertEquals(flightObj.getDepartureCity(), this.defaultDepartureCity);
        assertEquals(flightObj.getArrivalCity(), this.defaultArrivalCity);
        assertEquals(flightObj.getTotalSeats(), 75);
        assertEquals(flightObj.getAvailableSeats(), 75);
    }
}

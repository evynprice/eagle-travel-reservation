/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.goldeneagle.reservation.resources.City;
import com.goldeneagle.reservation.resources.Flight;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Joeseph Jackson
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     * Testing the constructor of the Flight.java class sets the proper attributes.
     */
    @Test
    public void testAFlightObjectCanBeCreated()
    {
        City departureCity = new City("Atlanta, GA");
        City arrivalCity = new City("Chattanooga, TN");
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");  
        Date now = new Date(); 
        Flight flightObj = new Flight("United 5701 ATL-CHA", now, departureCity, arrivalCity, 75);
        
        assertEquals(flightObj.getName(), "United 5701 ATL-CHA");
        assertEquals(flightObj.getDate(), now);
        assertEquals(flightObj.getDepartureCity(), departureCity);
        assertEquals(flightObj.getArrivalCity(), arrivalCity);
        assertEquals(flightObj.getTotalSeats(), 75);
        assertEquals(flightObj.getAvailableSeats(), 75);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldeneagle.reservation.resources;

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
public class DataGeneratorTest {
    DataGenerator defaultGen;
    
    public DataGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.defaultGen = new DataGenerator();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testDataGeneratorObjectCreated() {
        DataGenerator dataGenerator1 = new DataGenerator();
        assertTrue(dataGenerator1 instanceof DataGenerator);
    }
    
    @Test
    public void testDataGeneratorCanGenerateCost() {  
        for (int i = 0; i < 100; i++){
            assertNotNull(this.defaultGen.generateCost());
            assertTrue(this.defaultGen.generateCost() >= 0.00);
            assertTrue(this.defaultGen.generateCost() <= 1000.00);
        }
    }
    
    @Test
    public void testDataGeneratorCanGenerateFlightNumber(){            
        for (int i = 0; i < 100; i++) {
            assertNotNull(this.defaultGen.generateFlightNum());
            assertTrue(this.defaultGen.generateFlightNum()>0);
            assertTrue(this.defaultGen.generateFlightNum()<=9999);            
        }
    }
    
    @Test
    public void testDataGeneratorCanGenerateFlightTime(){
        
    }
    
    
}

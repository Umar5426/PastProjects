package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SupplyTest {
    
    private Supply supply;
    private Location location;

    @Before
    public void setUp() {
        // Initialize a new instance of Location before each test
        location = new Location("Home", "123 Main St");
    }

    @Test
    public void testConstructorWithLocation() {
        supply = new Supply("Water", 10, location);
        assertEquals("Water", supply.getType());
        assertEquals(10, supply.getQuantity());
        assertEquals(location, supply.getLocation());
    }

    @Test
    public void testConstructorWithoutLocation() {
        supply = new Supply("Food", 20);
        assertEquals("Food", supply.getType());
        assertEquals(20, supply.getQuantity());
        assertNull(supply.getLocation());
    }

    @Test
    public void testGetType() {
        supply = new Supply("Water", 10);
        assertEquals("Water", supply.getType());
    }

    @Test
    public void testSetType() {
        supply = new Supply("Water", 10);
        supply.setType("Food");
        assertEquals("Food", supply.getType());
    }

    @Test
    public void testGetQuantity() {
        supply = new Supply("Water", 10);
        assertEquals(10, supply.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        supply = new Supply("Water", 10);
        supply.setQuantity(15);
        assertEquals(15, supply.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeQuantity() {
        supply = new Supply("Water", 10);
        supply.setQuantity(-5);
        // Expecting IllegalArgumentException due to negative quantity
    }

    @Test
    public void testGetLocation() {
        supply = new Supply("Water", 10, location);
        assertEquals(location, supply.getLocation());
    }

    @Test
    public void testSetLocation() {
        Location newLocation = new Location("Office", "456 Business St");
        supply = new Supply("Water", 10);
        supply.setLocation(newLocation);
        assertEquals(newLocation, supply.getLocation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeQuantity() {
        supply = new Supply("Water", -10);
        // Expecting IllegalArgumentException due to negative quantity
    }
}

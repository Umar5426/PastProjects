package edu.ucalgary.oop;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LocationTest {

    private Location location;

    @Before
    public void setUp() {
        // Initialize a new instance of Location before each test
        location = new Location("Home", "123 Main St");
    }

    @Test
    public void testConstructor() {
        // Test constructor
        assertNotNull(location);
        assertEquals("Home", location.getName());
        assertEquals("123 Main St", location.getAddress());
        assertNotNull(location.getOccupants());
        assertNotNull(location.getSupplies());
        assertEquals(0, location.getOccupants().size());
        assertEquals(0, location.getSupplies().size());
    }

    @Test
    public void testSetName() {
        // Test setting name
        location.setName("Work");
        assertEquals("Work", location.getName());
    }

    @Test
    public void testSetAddress() {
        // Test setting address
        location.setAddress("456 Maple Ave");
        assertEquals("456 Maple Ave", location.getAddress());
    }

    @Test
    public void testAddOccupant() {
        // Test adding an occupant
        DisasterEntity occupant = new DisasterEntity("John");
        location.addOccupant(occupant);
        assertEquals(1, location.getOccupants().size());
        assertTrue(location.getOccupants().contains(occupant));
    }

    @Test
    public void testRemoveOccupant() {
        // Test removing an occupant
        DisasterEntity occupant = new DisasterEntity("Jane");
        location.addOccupant(occupant);
        location.removeOccupant(occupant);
        assertEquals(0, location.getOccupants().size());
        assertFalse(location.getOccupants().contains(occupant));
    }

    @Test
    public void testAddSupply() {
        // Test adding a supply
        Supply supply = new Supply("Water", 10);
        location.addSupply(supply);
        assertEquals(1, location.getSupplies().size());
        assertTrue(location.getSupplies().contains(supply));
    }

    @Test
    public void testRemoveSupply() {
        // Test removing a supply
        Supply supply = new Supply("Food", 20);
        location.addSupply(supply);
        location.removeSupply(supply);
        assertEquals(0, location.getSupplies().size());
        assertFalse(location.getSupplies().contains(supply));
    }

    @Test
    public void testSetOccupants() {
        // Test setting occupants
        List<DisasterEntity> occupants = new ArrayList<>();
        occupants.add(new DisasterEntity("Bob"));
        occupants.add(new DisasterEntity("Alice"));
        location.setOccupants(occupants);
        assertEquals(2, location.getOccupants().size());
    }

    @Test
    public void testSetSupplies() {
        // Test setting supplies
        List<Supply> supplies = new ArrayList<>();
        supplies.add(new Supply("Medicine", 30));
        supplies.add(new Supply("Blanket", 15));
        location.setSupplies(supplies);
        assertEquals(2, location.getSupplies().size());
    }
}

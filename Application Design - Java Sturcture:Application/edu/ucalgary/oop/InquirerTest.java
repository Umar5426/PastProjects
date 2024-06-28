package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InquirerTest {

    private Inquirer inquirer;

    @Before
    public void setUp() {
        // Initialize a new instance of Inquirer before each test
        inquirer = new Inquirer("John", "Doe", "123-456-7890", "Important information");
    }

    @Test
    public void testAddInteraction() {
        // Test adding an interaction
        inquirer.addInteraction("Interaction details");
        assertEquals(1, inquirer.getTotalInteractions());
    }

    @Test
    public void testRemoveInteraction() {
        // Test removing an interaction
        inquirer.addInteraction("Interaction details to be removed");
        inquirer.removeInteraction(0);
        assertEquals(0, inquirer.getTotalInteractions());
    }

    @Test
    public void testClearInteractionLog() {
        // Test clearing the interaction log
        inquirer.addInteraction("Interaction 1");
        inquirer.addInteraction("Interaction 2");
        inquirer.clearInteractionLog();
        assertEquals(0, inquirer.getTotalInteractions());
    }

    @Test
    public void testSearchInteractionLog() {
        // Test searching for interactions
        inquirer.addInteraction("Interaction with keyword");
        inquirer.addInteraction("Another interaction");
        assertEquals(1, inquirer.searchInteractionLog("keyword").size());
    }

    @Test
    public void testGetTotalInteractions() {
        // Test getting the total number of interactions
        inquirer.addInteraction("Interaction 1");
        inquirer.addInteraction("Interaction 2");
        assertEquals(2, inquirer.getTotalInteractions());
    }

    @Test
    public void testGetInteractionFrequency() {
        // Test getting the interaction frequency
        inquirer.addInteraction("Interaction 1");
        inquirer.addInteraction("Interaction 2");
        Map<String, Integer> frequencyMap = inquirer.getInteractionFrequency();
        assertEquals(Integer.valueOf(1), frequencyMap.get("Interaction 1"));
        assertEquals(Integer.valueOf(1), frequencyMap.get("Interaction 2"));
    }

    @Test
    public void testGetMostCommonInteraction() {
        // Test getting the most common interaction
        inquirer.addInteraction("Interaction 1");
        inquirer.addInteraction("Interaction 1");
        inquirer.addInteraction("Interaction 2");
        assertEquals("Interaction 1", inquirer.getMostCommonInteraction());
    }

    @Test
    public void testIsValidPhoneNumber() {
        // Test validating a phone number
        assertTrue(inquirer.isValidPhoneNumber("123-456-7890"));
        assertFalse(inquirer.isValidPhoneNumber("123-456-789")); // Invalid format
    }

    @Test
    public void testSetServicesPhoneNum() {
        // Test setting a valid phone number
        inquirer.setServicesPhoneNum("123-456-7890");
        assertEquals("123-456-7890", inquirer.getServicesPhoneNum());
        
        // Test setting an invalid phone number
        try {
            inquirer.setServicesPhoneNum("123-456-789"); // Invalid format
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Pass
        }
    }

    @Test
    public void testIsValidInfo() {
        // Test validating information
        assertTrue(inquirer.isValidInfo("Valid information"));
        assertFalse(inquirer.isValidInfo(null)); // Null info
    }

    @Test
    public void testSetInfo() {
        // Test setting valid information
        inquirer.setInfo("Valid information");
        assertEquals("Valid information", inquirer.getInfo());
        
        // Test setting invalid information
        try {
            inquirer.setInfo(null); // Null info
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Pass
        }
    }
}

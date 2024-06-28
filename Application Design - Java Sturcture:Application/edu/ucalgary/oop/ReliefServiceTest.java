package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate; // Import LocalDate

public class ReliefServiceTest {
    
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;

    @Before
    public void setUp() {
        // Initialize a new instance of Inquirer, MissingPerson, and Location before each test
        inquirer = new Inquirer("John", "Doe", "123-456-7890", "Info");
        missingPerson = new DisasterVictim("Jane", "Doe", "2000-01-01", "girl", "None");
        lastKnownLocation = new Location("Home", "123 Main St");
        
        // Initialize a new instance of ReliefService before each test
        LocalDate dateOfInquiry = LocalDate.parse("2024-03-14"); // Create LocalDate object
        reliefService = new ReliefService(inquirer, missingPerson, dateOfInquiry, "Info", lastKnownLocation);
    }

    @Test
    public void testGetInquirer() {
        assertEquals(inquirer, reliefService.getInquirer());
    }

    @Test
    public void testSetInquirer() {
        Inquirer newInquirer = new Inquirer("Alice", "Smith", "987-654-3210", "New Info");
        reliefService.setInquirer(newInquirer);
        assertEquals(newInquirer, reliefService.getInquirer());
    }

    @Test
    public void testGetMissingPerson() {
        assertEquals(missingPerson, reliefService.getMissingPerson());
    }

    @Test
    public void testSetMissingPerson() {
        DisasterVictim newMissingPerson = new DisasterVictim("John", "Doe", "1990-01-01", "boy", "missing");
        reliefService.setMissingPerson(newMissingPerson);
        assertEquals(newMissingPerson, reliefService.getMissingPerson());
    }

    @Test
    public void testGetDateOfInquiry() {
        assertEquals(LocalDate.parse("2024-03-14"), reliefService.getDateOfInquiry());
    }

    @Test
    public void testSetDateOfInquiry() {
        String newDateOfInquiry = "2024-03-15"; // Date in string format
        reliefService.setDateOfInquiry(newDateOfInquiry);
        assertEquals(LocalDate.parse(newDateOfInquiry), reliefService.getDateOfInquiry());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidDateFormat() {
        String invalidDate = "03/15/2024"; // Invalid date format in string
        reliefService.setDateOfInquiry(invalidDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    @Test
    public void testGetInfoProvided() {
        assertEquals("Info", reliefService.getInfoProvided());
    }

    @Test
    public void testSetInfoProvided() {
        reliefService.setInfoProvided("New Info");
        assertEquals("New Info", reliefService.getInfoProvided());
    }

    @Test
    public void testGetLastKnownLocation() {
        assertEquals(lastKnownLocation, reliefService.getLastKnownLocation());
    }

    @Test
    public void testSetLastKnownLocation() {
        Location newLastKnownLocation = new Location("Office", "456 Business St");
        reliefService.setLastKnownLocation(newLastKnownLocation);
        assertEquals(newLastKnownLocation, reliefService.getLastKnownLocation());
    }

    @Test
    public void testGetLogDetails() {
        assertEquals("Inquirer: John, Missing Person: Jane, Date of Inquiry: 2024-03-14, Info Provided: Info, Last Known Location: Home", reliefService.getLogDetails());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidDateOfInquiryFormat() {
        // Test setting invalid date format
        reliefService.setDateOfInquiry("03/15/2024"); // Pass the date as a string
        // Expecting IllegalArgumentException due to invalid date format
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetNullDateOfInquiry() {
        // Test setting null date
        reliefService.setDateOfInquiry(null);
        // Expecting IllegalArgumentException due to null date
    }    
}

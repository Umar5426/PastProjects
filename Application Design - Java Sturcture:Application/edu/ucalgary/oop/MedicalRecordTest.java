package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalRecordTest {

    private MedicalRecord medicalRecord;

    @Before
    public void setUp() {
        // Initialize a new instance of MedicalRecord before each test
        medicalRecord = new MedicalRecord("Treatment details", "2024-03-14");
    }

    @Test
    public void testConstructorWithLocation() {
        // Test constructor with location
        Location location = new Location("Hospital", "123 Medical St");
        MedicalRecord medicalRecord = new MedicalRecord(location, "Treatment details", "2024-03-14");
        assertNotNull(medicalRecord);
        assertEquals(location, medicalRecord.getLocation());
        assertEquals("Treatment details", medicalRecord.getTreatmentDetails());
        assertEquals("2024-03-14", medicalRecord.getDateOfTreatment());
    }

    @Test
    public void testConstructorWithoutLocation() {
        // Test constructor without location
        assertNotNull(medicalRecord);
        assertNull(medicalRecord.getLocation());
        assertEquals("Treatment details", medicalRecord.getTreatmentDetails());
        assertEquals("2024-03-14", medicalRecord.getDateOfTreatment());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidDateFormat() {
        // Test constructor with invalid date format
        new MedicalRecord("Treatment details", "03/14/2024");
        // Expecting IllegalArgumentException due to invalid date format
    }

    @Test
    public void testSetLocation() {
        // Test setting location
        Location location = new Location("Clinic", "456 Health Ave");
        medicalRecord.setLocation(location);
        assertEquals(location, medicalRecord.getLocation());
    }

    @Test
    public void testSetTreatmentDetails() {
        // Test setting treatment details
        medicalRecord.setTreatmentDetails("New treatment details");
        assertEquals("New treatment details", medicalRecord.getTreatmentDetails());
    }

    @Test
    public void testSetDateOfTreatment() {
        // Test setting date of treatment
        medicalRecord.setDateOfTreatment("2024-03-15");
        assertEquals("2024-03-15", medicalRecord.getDateOfTreatment());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidDateFormat() {
        // Test setting invalid date format
        medicalRecord.setDateOfTreatment("03/15/2024");
        // Expecting IllegalArgumentException due to invalid date format
    }
}

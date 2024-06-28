package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class DisasterEntityTest {

    private DisasterEntity entity;

    @Before
    public void setUp() {
        // Initialize a new instance of DisasterEntity before each test
        entity = new DisasterEntity("John");
    }

    @Test
    public void testConstructorWithValidInput() {
        // Test constructor with valid input
        DisasterEntity entity = new DisasterEntity("John","Doe", "2000-01-01", "boy", "Caucasian");
        assertNotNull(entity);
        assertEquals("John", entity.getFirstName());
        assertEquals("Doe", entity.getLastName());
        assertEquals("2000-01-01", entity.getDateOfBirth());
        assertEquals("boy", entity.getGender());
        assertEquals("Caucasian", entity.getComments());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidInput() {
        // Test constructor with invalid input
        new DisasterEntity(null);
        // Expecting IllegalArgumentException due to null first name
    }
    

    @Test
    public void testSetAndGetFirstName() {
        // Test set and get methods for first name
        entity.setFirstName("Alice");
        assertEquals("Alice", entity.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        // Test set and get methods for last name
        entity.setLastName("Doe");
        assertEquals("Doe", entity.getLastName());
    }

    @Test
    public void testSetDateOfBirth() {
        // Test setting date of birth
        entity.setDateOfBirth("2000-01-01");
        assertEquals("2000-01-01", entity.getDateOfBirth());
        assertNull(entity.getAge()); // Ensure age is null when date of birth is set
    }

    @Test
    public void testSetAge() {
        // Test setting age
        entity.setAge(25);
        assertEquals(Integer.valueOf(25), entity.getAge());
        assertNull(entity.getDateOfBirth()); // Ensure date of birth is null when age is set
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithAgeAlreadySet() {
        // Test setting date of birth when age is already set
        entity.setAge(25);
        entity.setDateOfBirth("2000-01-01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeWithDateOfBirthAlreadySet() {
        // Test setting age when date of birth is already set
        entity.setDateOfBirth("2000-01-01");
        entity.setAge(25);
    }

    @Test
    public void testSetAndGetGender() {
        // Test set and get methods for gender
        entity.setGender("boy");
        assertEquals("boy", entity.getGender());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidGender() {
        // Test setting an invalid gender
        entity.setGender("invalidGender");
        // Expecting IllegalArgumentException
    }

    @Test
    public void testSetAndGetComments() {
        // Test set and get methods for comments
        entity.setComments("Some comments");
        assertEquals("Some comments", entity.getComments());
    }

    // Negative test for setting an empty first name
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmptyFirstName() {
        // Test setting an empty first name
        entity.setFirstName("");
        // Expecting IllegalArgumentException
    }

    @Test
    public void testSetandGetDietaryRestrictions() {
        // Test setDietaryRestrictions and getDietaryRestrictions
        Set<DisasterEntity.DietaryRestriction> newRestrictions = new HashSet<>();
        newRestrictions.add(DisasterEntity.DietaryRestriction.VGML);
        newRestrictions.add(DisasterEntity.DietaryRestriction.GFML);
        entity.setDietaryRestrictions(newRestrictions);
    
        Set<DisasterEntity.DietaryRestriction> updatedRestrictions = entity.getDietaryRestrictions();
        assertNotNull(updatedRestrictions);
        assertEquals(2, updatedRestrictions.size());
        assertTrue(updatedRestrictions.contains(DisasterEntity.DietaryRestriction.VGML));
        assertTrue(updatedRestrictions.contains(DisasterEntity.DietaryRestriction.GFML));
    
        // Test updating dietary restrictions
        newRestrictions.remove(DisasterEntity.DietaryRestriction.VGML);
        entity.setDietaryRestrictions(newRestrictions);
    
        Set<DisasterEntity.DietaryRestriction> removedRestrictions = entity.getDietaryRestrictions();
        assertNotNull(removedRestrictions);
        assertEquals(1, removedRestrictions.size());
        assertFalse(removedRestrictions.contains(DisasterEntity.DietaryRestriction.VGML));
        assertTrue(removedRestrictions.contains(DisasterEntity.DietaryRestriction.GFML));
    }
    


    // Negative test for setting null dietary restrictions
    @Test(expected = IllegalArgumentException.class)
    public void testSetNullDietaryRestrictions() {
        entity.setDietaryRestrictions(null);
        // Expecting IllegalArgumentException
    }
}

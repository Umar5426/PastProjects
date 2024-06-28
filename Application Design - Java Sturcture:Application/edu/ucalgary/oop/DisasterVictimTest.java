package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.*;

public class DisasterVictimTest {

    private DisasterVictim victim;
    private DisasterVictim victimWithAge;

    @Before
    public void setUp() {
        // Initialize a new instance of DisasterVictim before each test
        victim = new DisasterVictim("John", "2000-01-01");
        victimWithAge = new DisasterVictim("Jane");
    }

    @Test
    public void testGetAssignedSocialID() {
        assertEquals(1, victim.getAssignedSocialID());
    }
    
    @Test
    public void testConstructorWithValidInput() {
        // Test constructor with valid input
        DisasterVictim victim = new DisasterVictim("John", "2000-01-01");
        assertNotNull(victim);
        assertEquals("John", victim.getFirstName());
        assertEquals("2000-01-01", victim.getDateOfBirth());
        // Test other attributes...
    }

    @Test
    public void testSetAndGetFirstName() {
        // Test set and get methods for first name
        victim.setFirstName("Alice");
        assertEquals("Alice", victim.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        // Test set and get methods for last name
        victim.setLastName("Doe");
        assertEquals("Doe", victim.getLastName());
    }

    @Test //For this test, it is important that "boy" be replaced with a valid value from the new GenderOptions.txt file.
    public void testSetAndGetGender() {//This test will fail if boy is not in the GenderOptions.txt file.
        // Test set and get methods for gender
        victim.setGender("boy");
        assertEquals("boy", victim.getGender());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidGender() {
        // Test setting an invalid gender
        victim.setGender("invalid");
        // Expecting IllegalArgumentException
    }

    @Test
    public void testSetAndGetComments() {
        // Test set and get methods for comments
        victim.setComments("Test comments");
        assertEquals("Test comments", victim.getComments());
    }

    @Test
    public void testSetAndGetDateOfBirth() {
        // Test set and get methods for date of birth
        victim.setDateOfBirth("2000-01-01");
        assertEquals("2000-01-01", victim.getDateOfBirth());
    }

    @Test
    public void testSetAndGetAge() {
        // Test set and get methods for age
        victimWithAge.setAge(21);
        assertEquals(Integer.valueOf(21), Integer.valueOf(victimWithAge.getAge()));
    }

    @Test
    public void testSetAndGetDietaryRestrictions() {
        // Test set and get methods for dietary restrictions
        Set<DisasterVictim.DietaryRestriction> restrictions = Set.of(DisasterVictim.DietaryRestriction.AVML);
        victim.setDietaryRestrictions(restrictions);
        assertTrue(victim.getDietaryRestrictions().contains(DisasterVictim.DietaryRestriction.AVML));
    }

    @Test
    public void testAddAndRemoveDietaryRestriction() {
        // Test adding and removing dietary restrictions
        victim.addDietaryRestriction(DisasterVictim.DietaryRestriction.AVML);
        assertTrue(victim.getDietaryRestrictions().contains(DisasterVictim.DietaryRestriction.AVML));

        victim.removeDietaryRestriction(DisasterVictim.DietaryRestriction.AVML);
        assertFalse(victim.getDietaryRestrictions().contains(DisasterVictim.DietaryRestriction.AVML));
    }

    @Test
    public void testAddAndRemoveFamilyConnection() {
        // Test adding and removing family connections
        DisasterVictim alice = new DisasterVictim("Alice", "2000-01-01");
        DisasterVictim bob = new DisasterVictim("Bob", "2000-01-02");

        FamilyRelation relation1 = new FamilyRelation(alice, "Sister", bob);
        FamilyRelation relation2 = new FamilyRelation(alice, "Brother", bob);

        victim.addFamilyConnection(relation1);
        victim.addFamilyConnection(relation2);

        assertEquals(2, victim.getFamilyConnections().size());

        victim.removeFamilyConnection(relation1);
        assertEquals(1, victim.getFamilyConnections().size());
    }
}

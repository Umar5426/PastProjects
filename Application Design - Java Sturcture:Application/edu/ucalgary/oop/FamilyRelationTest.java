package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FamilyRelationTest{

    private DisasterVictim personOne;
    private DisasterVictim personTwo;
    private FamilyRelation familyRelation;

    @Before
    public void setUp() {
        // Initialize a new instance of DisasterVictim before each test
        personOne = new DisasterVictim("John", "2000-01-01");
        personTwo = new DisasterVictim("Alice", "1995-05-15");
        familyRelation = new FamilyRelation(personOne, "Sibling", personTwo);
    }

    @Test
    public void testConstructor() {
        // Test constructor
        assertNotNull(familyRelation);
        assertEquals(personOne, familyRelation.getPersonOne());
        assertEquals("Sibling", familyRelation.getRelationshipTo());
        assertEquals(personTwo, familyRelation.getPersonTwo());
    }

    @Test
    public void testSetAndGetPersonOne() {
        // Test set and get methods for personOne
        DisasterVictim newPersonOne = new DisasterVictim("Bob", "1998-03-20");
        familyRelation.setPersonOne(newPersonOne);
        assertEquals(newPersonOne, familyRelation.getPersonOne());
    }

    @Test
    public void testSetAndGetRelationshipTo() {
        // Test set and get methods for relationshipTo
        familyRelation.setRelationshipTo("Parent");
        assertEquals("Parent", familyRelation.getRelationshipTo());
    }

    @Test
    public void testSetAndGetPersonTwo() {
        // Test set and get methods for personTwo
        DisasterVictim newPersonTwo = new DisasterVictim("Eve", "2005-11-10");
        familyRelation.setPersonTwo(newPersonTwo);
        assertEquals(newPersonTwo, familyRelation.getPersonTwo());
    }

    @Test
    public void testEnsureTwoSidedRelationship() {
        // Test if the relationship is added to both persons
        assertNotNull(personOne.getFamilyConnections());
        assertNotNull(personTwo.getFamilyConnections());
        assertEquals(1, personOne.getFamilyConnections().size());
        assertEquals(1, personTwo.getFamilyConnections().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullRelationshipTo() {
        // Test setting an invalid relationship
        familyRelation.setRelationshipTo(null);
        // Expecting IllegalArgumentException
    }
    
}
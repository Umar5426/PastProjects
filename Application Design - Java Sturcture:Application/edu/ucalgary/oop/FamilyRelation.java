package edu.ucalgary.oop;

public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    /**
     * Constructs a FamilyRelation object between two DisasterVictim instances.
     * 
     * @param personOne      the first DisasterVictim involved in the relationship
     * @param relationshipTo the relationship between the two victims
     * @param personTwo      the second DisasterVictim involved in the relationship
     */
    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
        
        // Adding the relationship to both victims
        personOne.addFamilyConnection(this);
        personTwo.addFamilyConnection(this);
    }

    public DisasterVictim getPersonOne() {
        return personOne;
    }

    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }

    public String getRelationshipTo() {
        return relationshipTo;
    }

    public void setRelationshipTo(String relationshipTo) {
        if (relationshipTo == null) {
            throw new IllegalArgumentException("Relationship to cannot be null.");
        }
        this.relationshipTo = relationshipTo;
    }

    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }
}
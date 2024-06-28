package edu.ucalgary.oop;

import java.util.*;

public class DisasterVictim extends DisasterEntity {
    // Attributes
    private int counter = 0;
    private final int ASSIGNED_SOCIAL_ID;
    private boolean isAlive;
    private String causeOfDeath;
    private List<FamilyRelation> familyConnections;

    // Constructors

    /**
     * Constructs a DisasterVictim with the specified first name.
     * 
     * @param firstName the first name of the victim
     */
    public DisasterVictim(String firstName) {
        super(firstName);
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.isAlive = true; // Assuming the victim is initially alive
        this.dietaryRestrictions = new HashSet<>();
    }

    /**
     * Constructs a DisasterVictim with the specified first name and date of birth.
     * 
     * @param firstName   the first name of the victim
     * @param dateOfBirth the date of birth of the victim
     */
    public DisasterVictim(String firstName, String dateOfBirth) {
        super(firstName, dateOfBirth);
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.isAlive = true; // Assuming the victim is initially alive
        this.dietaryRestrictions = new HashSet<>();
    }

    /**
     * Constructs a DisasterVictim with the specified first name and age.
     * 
     * @param firstName the first name of the victim
     * @param age       the age of the victim
     */
    public DisasterVictim(String firstName, Integer age) {
        super(firstName, age);
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.isAlive = true; // Assuming the victim is initially alive
        this.dietaryRestrictions = new HashSet<>();
    }

    /**
     * Constructs a DisasterVictim with the specified attributes.
     * 
     * @param firstName   the first name of the victim
     * @param lastName    the last name of the victim
     * @param dateOfBirth the date of birth of the victim
     * @param gender      the gender of the victim
     * @param comments    additional comments about the victim
     */
    public DisasterVictim(String firstName, String lastName, String dateOfBirth, String gender, String comments) {
        super(firstName, lastName, dateOfBirth, gender, comments);
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.isAlive = true; // Assuming the victim is initially alive
        this.dietaryRestrictions = new HashSet<>();
    }

    /**
     * Constructs a DisasterVictim with the specified attributes.
     * 
     * @param firstName the first name of the victim
     * @param lastName  the last name of the victim
     * @param age       the age of the victim
     * @param gender    the gender of the victim
     * @param comments  additional comments about the victim
     */
    public DisasterVictim(String firstName, String lastName, Integer age, String gender, String comments) {
        super(firstName, lastName, age, gender, comments);
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.isAlive = true; // Assuming the victim is initially alive
        this.dietaryRestrictions = new HashSet<>();
    }

    // Other Methods

    /**
     * Generates a social ID for the victim.
     * 
     * @return the generated social ID
     */
    private int generateSocialID() {
        counter++;
        return counter;
    }

    // Getters and Setters

    /**
     * Retrieves the assigned social ID of the victim.
     * 
     * @return the assigned social ID
     */
    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    /**
     * Checks if the victim is alive.
     * 
     * @return true if the victim is alive, otherwise false
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Sets the alive status of the victim.
     * 
     * @param alive the alive status to set
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Retrieves the cause of death of the victim.
     * 
     * @return the cause of death
     */
    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    /**
     * Sets the cause of death of the victim.
     * 
     * @param causeOfDeath the cause of death to set
     */
    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    /**
     * Adds a family connection to the victim.
     * 
     * @param familyRelation the family connection to add
     */
    public void addFamilyConnection(FamilyRelation familyRelation) {
        if (familyConnections == null) {
            familyConnections = new ArrayList<>();
        }
        familyConnections.add(familyRelation);
    }

    /**
     * Removes a family connection from the victim.
     * 
     * @param familyRelation the family connection to remove
     */
    public void removeFamilyConnection(FamilyRelation familyRelation) {
        if (familyConnections != null) {
            familyConnections.remove(familyRelation);
        }
    }

    /**
     * Retrieves the family connections of the victim.
     * 
     * @return the list of family connections
     */
    public List<FamilyRelation> getFamilyConnections() {
        return familyConnections;
    }

    /**
     * Sets the family connections of the victim.
     * 
     * @param familyConnections the list of family connections to set
     */
    public void setFamilyConnections(List<FamilyRelation> familyConnections) {
        this.familyConnections = familyConnections;
    }

    /**
     * Retrieves the basic information of the victim including the date of birth.
     * 
     * @return the basic information with date of birth
     */
    public String getBasicInfoWithDateofBirth() {
        return "Name: " + getFirstName() + " " + getLastName() +
                "\nDate of Birth: " + getDateOfBirth() +
                "\nGender: " + getGender() +
                "\nComments: " + getComments();
    }

    /**
     * Retrieves the basic information of the victim including the age.
     * 
     * @return the basic information with age
     */
    public String getBasicInfoWithAge() {
        return "Name: " + getFirstName() + " " + getLastName() +
                "\nAge: " + getAge() +
                "\nGender: " + getGender() +
                "\nComments: " + getComments();
    }
}

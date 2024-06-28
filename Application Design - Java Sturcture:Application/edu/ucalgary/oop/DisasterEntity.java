package edu.ucalgary.oop;

import java.util.*;
import java.io.*;

public class DisasterEntity {
    // Attributes
    protected String firstName;
    protected String lastName;
    protected String dateOfBirth;
    protected Integer age;
    protected String gender;
    protected String comments;
    protected Set<DisasterVictim.DietaryRestriction> dietaryRestrictions;

    // Constructors

    /**
     * Constructs a DisasterEntity with the specified first name.
     * 
     * @param firstName the first name of the entity
     */
    public DisasterEntity(String firstName) {
        setFirstName(firstName);
    }

    /**
     * Constructs a DisasterEntity with the specified first name and date of birth.
     * 
     * @param firstName   the first name of the entity
     * @param dateOfBirth the date of birth of the entity
     */
    public DisasterEntity(String firstName, String dateOfBirth) {
        setFirstName(firstName);
        setDateOfBirth(dateOfBirth);
    }

    /**
     * Constructs a DisasterEntity with the specified attributes.
     * 
     * @param firstName   the first name of the entity
     * @param lastName    the last name of the entity
     * @param dateOfBirth the date of birth of the entity
     * @param gender      the gender of the entity
     * @param comments    additional comments about the entity
     */
    public DisasterEntity(String firstName, String lastName, String dateOfBirth, String gender, String comments) {
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setComments(comments);
    }

    /**
     * Constructs a DisasterEntity with the specified attributes.
     * 
     * @param firstName the first name of the entity
     * @param lastName  the last name of the entity
     * @param age       the age of the entity
     * @param gender    the gender of the entity
     * @param comments  additional comments about the entity
     */
    public DisasterEntity(String firstName, String lastName, Integer age, String gender, String comments) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setGender(gender);
        setComments(comments);
    }

    // Other Methods
    /**
     * Constructs a DisasterEntity with the specified first name and age.
     * 
     * @param firstName the first name of the entity
     * @param age       the age of the entity
     */
    public DisasterEntity(String firstName, Integer age) {
        setFirstName(firstName);
        setAge(age);
    }

    // Getters and Setters

    /**
     * Retrieves the first name of the entity.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the entity.
     * 
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName == "") {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the entity.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the entity.
     * 
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the gender of the entity.
     * 
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the entity.
     * 
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        try {
            GenderValidator validator = new GenderValidator();
            if (!validator.isValidGender(gender)) {
                throw new IllegalArgumentException("Invalid gender.");
            }
            this.gender = gender;
        } catch (IOException e) {
            System.err.println("Error reading gender options file: " + e.getMessage());
        }
    }

    /**
     * Retrieves the comments about the entity.
     * 
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the comments about the entity.
     * 
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Retrieves the date of birth of the entity.
     * 
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the entity.
     * 
     * @param dateOfBirth the date of birth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        if (age != null) {
            throw new IllegalArgumentException("Date of Birth cannot be set once an Age value is inputed.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the age of the entity.
     * 
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age of the entity.
     * 
     * @param age the age to set
     */
    public void setAge(Integer age) {
        if (dateOfBirth != null) {
            throw new IllegalArgumentException("Cannot set age when date of birth is already set.");
        }
        this.age = age;
    }

    /**
     * Retrieves the dietary restrictions of the entity.
     * 
     * @return the dietary restrictions
     */
    public Set<DisasterVictim.DietaryRestriction> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    /**
     * Sets the dietary restrictions of the entity.
     * 
     * @param dietaryRestrictions the dietary restrictions to set
     */
    public void setDietaryRestrictions(Set<DisasterVictim.DietaryRestriction> dietaryRestrictions) {
        if (dietaryRestrictions == null) {
            throw new IllegalArgumentException("Cannot set a NULL Dietary Restriction.");
        }
        this.dietaryRestrictions = dietaryRestrictions;
    }

    /**
     * Adds a dietary restriction to the entity.
     * 
     * @param restriction the dietary restriction to add
     */
    public void addDietaryRestriction(DietaryRestriction restriction) {
        dietaryRestrictions.add(restriction);
    }

    /**
     * Removes a dietary restriction from the entity.
     * 
     * @param restriction the dietary restriction to remove
     */
    public void removeDietaryRestriction(DietaryRestriction restriction) {
        dietaryRestrictions.remove(restriction);
    }

    /**
     * Enumeration representing dietary restrictions.
     */
    public enum DietaryRestriction {
        AVML, // Asian vegetarian meal
        DBML, // Diabetic meal
        GFML, // Gluten intolerant meal
        KSML, // Kosher meal
        LSML, // Low salt meal
        MOML, // Muslim meal
        PFML, // Peanut-free meal
        VGML, // Vegan meal
        VJML  // Vegetarian Jain meal
    }
}

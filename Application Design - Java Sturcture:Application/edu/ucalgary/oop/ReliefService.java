package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.*;

public class ReliefService {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private LocalDate dateOfInquiry; // Change type to LocalDate
    private String infoProvided;
    private Location lastKnownLocation;

    // Constructor
    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, LocalDate dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = dateOfInquiry;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }

    // Getter and setter for inquirer
    public Inquirer getInquirer() {
        return inquirer;
    }

    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }

    // Getter and setter for missingPerson
    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }

    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    // Getter and setter for dateOfInquiry
    public LocalDate getDateOfInquiry() {
        return dateOfInquiry;
    }

    public void setDateOfInquiry(String dateOfInquiry) {
        if (dateOfInquiry == null) {
            throw new IllegalArgumentException("Date of Inquiry cannot be NULL.");
        }

        // Define patterns for different date formats
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("y/M/d");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("y-M-d");

        try {
            // Try parsing with the first pattern
            this.dateOfInquiry = LocalDate.parse(dateOfInquiry, formatter1);
        } catch (DateTimeParseException e1) {
            try {
                // Try parsing with the second pattern
                this.dateOfInquiry = LocalDate.parse(dateOfInquiry, formatter2);
            } catch (DateTimeParseException e2) {
                // Throw exception if neither pattern matches
                throw new IllegalArgumentException("Invalid date format. Please use 'year/month/day' or 'year-month-day'.");
            }
        }
    }

    // Getter and setter for infoProvided
    public String getInfoProvided() {
        return infoProvided;
    }

    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }

    // Getter and setter for lastKnownLocation
    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    // Method to get a summary of the relief service
    public String getLogDetails() {
        return "Inquirer: " + inquirer.getFirstName() +
                ", Missing Person: " + missingPerson.getFirstName() +
                ", Date of Inquiry: " + dateOfInquiry +
                ", Info Provided: " + infoProvided +
                ", Last Known Location: " + lastKnownLocation.getName();
    }
}

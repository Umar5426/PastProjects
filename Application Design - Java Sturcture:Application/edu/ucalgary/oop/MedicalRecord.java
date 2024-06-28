package edu.ucalgary.oop;

import java.time.*;
import java.time.format.*;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;

    // Constructor with location, treatment details, and date of treatment
    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
        setLocation(location);
        this.treatmentDetails = treatmentDetails;

        // Check if the date of treatment string matches the expected date format
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format for treatment details. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    // Constructor with only treatment details and date of treatment
    public MedicalRecord(String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
        this.treatmentDetails = treatmentDetails;

        // Check if the date of treatment string matches the expected date format
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format for treatment details. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    // Getter and setter for location
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // Getter for treatmentDetails
    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    // Setter for treatmentDetails
    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    // Getter and setter for dateOfTreatment
    public String getDateOfTreatment() {
        return dateOfTreatment;
    }

    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
        // Check if the date of treatment string matches the expected date format
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    // Helper method to check if a string matches the YYYY-MM-DD date format
    private boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
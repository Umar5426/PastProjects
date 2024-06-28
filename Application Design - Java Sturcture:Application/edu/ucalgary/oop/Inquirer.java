package edu.ucalgary.oop;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Inquirer extends DisasterEntity {
    private String servicesPhoneNum; // Phone number of the services
    private String info; // Information provided by the inquirer
    private List<InquirerInteraction> interactionLog; // Log of interactions

    // Constructor
    public Inquirer(String firstName, String lastName, String phone, String info) {
        super(firstName, lastName);
        this.servicesPhoneNum = phone;
        this.info = info;
        this.interactionLog = new ArrayList<>();
    }

    // Method to add a new interaction to the log
    public void addInteraction(String interactionDetails) {
        LocalDateTime interactionTime = LocalDateTime.now();
        InquirerInteraction interaction = new InquirerInteraction(interactionTime, interactionDetails);
        interactionLog.add(interaction);
    }

    // Method to update an existing interaction in the log
    public void updateInteraction(int index, String newDetails) {
        if (index >= 0 && index < interactionLog.size()) {
            interactionLog.get(index).setInteractionDetails(newDetails);
        } else {
            throw new IllegalArgumentException("Invalid interaction index.");
        }
    }

    // Method to remove an interaction from the log
    public void removeInteraction(int index) {
        if (index >= 0 && index < interactionLog.size()) {
            interactionLog.remove(index);
        } else {
            throw new IllegalArgumentException("Invalid interaction index.");
        }
    }

    // Method to clear the entire interaction log
    public void clearInteractionLog() {
        interactionLog.clear();
    }

    // Method to search interactions in the log based on a keyword
    public List<InquirerInteraction> searchInteractionLog(String keyword) {
        List<InquirerInteraction> results = new ArrayList<>();
        for (InquirerInteraction interaction : interactionLog) {
            if (interaction.getInteractionDetails().contains(keyword)) {
                results.add(interaction);
            }
        }
        return results;
    }

    // Method to export the interaction log to a file
    public void exportInteractionLog(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (InquirerInteraction interaction : interactionLog) {
                writer.println(interaction.getInteractionTime() + ": " + interaction.getInteractionDetails());
            }
            System.out.println("Interaction log exported successfully to " + filename);
        }
    }

    // Method to get the total number of interactions in the log
    public int getTotalInteractions() {
        return interactionLog.size();
    }

    // Method to get the frequency of each interaction in the log
    public Map<String, Integer> getInteractionFrequency() {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (InquirerInteraction interaction : interactionLog) {
            String details = interaction.getInteractionDetails();
            frequencyMap.put(details, frequencyMap.getOrDefault(details, 0) + 1);
        }
        return frequencyMap;
    }

    // Method to get the most common interaction in the log
    public String getMostCommonInteraction() {
        Map<String, Integer> frequencyMap = getInteractionFrequency();
        String mostCommon = null;
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostCommon = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return mostCommon;
    }

    // Method to check if a phone number is in a valid format
    public boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "\\d{3}-\\d{3}-\\d{4}";
        return phoneNumber.matches(regex);
    }

    // Method to set the services phone number
    public void setServicesPhoneNum(String phone) {
        if (isValidPhoneNumber(phone)) {
            this.servicesPhoneNum = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number format.");
        }
    }

    // Method to check if information is valid
    public boolean isValidInfo(String info) {
        return info != null && !info.isEmpty();
    }

    // Method to set the information provided by the inquirer
    public void setInfo(String info) {
        if (isValidInfo(info)) {
            this.info = info;
        } else {
            throw new IllegalArgumentException("Invalid information.");
        }
    }

    // Inner class representing an interaction
    private static class InquirerInteraction {
        private final LocalDateTime interactionTime;
        private String interactionDetails;

        // Constructor
        public InquirerInteraction(LocalDateTime interactionTime, String interactionDetails) {
            this.interactionTime = interactionTime;
            this.interactionDetails = interactionDetails;
        }

        // Getter for interaction time
        public LocalDateTime getInteractionTime() {
            return interactionTime;
        }

        // Getter for interaction details
        public String getInteractionDetails() {
            return interactionDetails;
        }

        // Setter for interaction details
        public void setInteractionDetails(String interactionDetails) {
            this.interactionDetails = interactionDetails;
        }
    }

    // Getter for services phone number
    public String getServicesPhoneNum() {
        return servicesPhoneNum;
    }

    // Getter for information provided by the inquirer
    public String getInfo() {
        return info;
    }
}
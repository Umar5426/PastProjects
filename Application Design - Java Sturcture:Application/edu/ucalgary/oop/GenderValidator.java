package edu.ucalgary.oop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GenderValidator {
    private Set<String> genderOptions; // Set to store valid gender options

    /**
     * Constructs a GenderValidator object and initializes it with default gender options from a file.
     * 
     * @throws IOException if an I/O error occurs while reading the gender options file
     */
    public GenderValidator() throws IOException {
        this("edu/ucalgary/oop/GenderOptions.txt"); // Assuming gender options file is in the same directory
    }

    /**
     * Constructs a GenderValidator object and initializes it with gender options from a specified file.
     * 
     * @param filePath the path to the file containing gender options
     * @throws IOException if an I/O error occurs while reading the gender options file
     */
    public GenderValidator(String filePath) throws IOException {
        genderOptions = new HashSet<>();
        readGenderOptions(filePath);
    }

    /**
     * Reads gender options from a specified file and populates the genderOptions set.
     * 
     * @param filePath the path to the file containing gender options
     * @throws IOException if an I/O error occurs while reading the gender options file
     */
    private void readGenderOptions(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                genderOptions.add(line.trim().toLowerCase());
            }
        }
    }

    /**
     * Checks if a given gender string is valid by comparing it with the set of valid gender options.
     * 
     * @param gender the gender string to be validated
     * @return true if the gender is valid, false otherwise
     */
    public boolean isValidGender(String gender) {
        return genderOptions.contains(gender.trim().toLowerCase());
    }
}

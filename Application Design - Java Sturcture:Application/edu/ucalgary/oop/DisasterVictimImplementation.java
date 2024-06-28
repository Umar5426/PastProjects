package edu.ucalgary.oop;

import java.util.*; 


public class DisasterVictimImplementation implements DisasterVictimInterface {

    private DisasterVictim victim; // Instance of DisasterVictim interface or class

    private List<DisasterVictimImplementation> victimList;

    public DisasterVictimImplementation() {
        victimList = new ArrayList<>();
    }

    /**
     * Adds a victim to the victim list.
     * 
     * @param victim the victim to add
     */
    public void addVictim(DisasterVictimImplementation victim) {
        victimList.add(victim);
    }

    /**
     * Prints basic information of all victims in the victim list.
     */
    public void printAllVictimsInfo() {
        for (DisasterVictimImplementation victim : victimList) {
            System.out.println(victim.getBasicInfo());
            System.out.println("Dietary Restrictions: " + victim.getDietaryRestrictions());
            System.out.println();
        }
    }

    @Override
    public void setBasicInfoUsingDateofBirth(String firstName, String lastName, String dateOfBirth, String gender, String comments) {
        victim = new DisasterVictim(firstName, lastName, dateOfBirth, gender, comments);
    }

    @Override
    public void setBasicInfoUsingAge(String firstName, String lastName, Integer age, String gender, String comments) {
        // Assuming the DisasterVictim class/interface has a constructor/method to handle age
        victim = new DisasterVictim(firstName, lastName, age, gender, comments);
    }

    @Override
    public void setDietaryRestrictions(Set<DisasterVictim.DietaryRestriction> dietaryRestrictions) {
        // Assuming the DisasterVictim class/interface has a method to set dietary restrictions
        victim.setDietaryRestrictions(dietaryRestrictions);
    }

    @Override
    public String getBasicInfoWithAge() {
        // Assuming the DisasterVictim class/interface has a method to get basic information with age
        return victim.getBasicInfoWithAge();
    }

    @Override
    public String getBasicInfoWithDateofBirth() {
        // Assuming the DisasterVictim class/interface has a method to get basic information with date of birth
        return victim.getBasicInfoWithDateofBirth();
    }

    @Override
    public String getBasicInfo() {
        if (victim instanceof DisasterVictim) {
            DisasterVictim disasterVictim = (DisasterVictim) victim;
            if (disasterVictim.getAge() != null) {
                return disasterVictim.getBasicInfoWithAge();
            } else if (disasterVictim.getDateOfBirth() != null && !disasterVictim.getDateOfBirth().isEmpty()) {
                return disasterVictim.getBasicInfoWithDateofBirth();
            }
        }
        return "Basic information not available";
    }
    
    @Override
    public Set<DisasterVictim.DietaryRestriction> getDietaryRestrictions() {
        // Assuming the DisasterVictim class/interface has a method to get dietary restrictions
        return victim.getDietaryRestrictions();
    }

    /**
     * Runs the DisasterVictimImplementation program.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Disaster Victim Information");
            System.out.println("2. Set Dietary Restrictions");
            System.out.println("3. Get Disaster Victim Information");
            System.out.println("4. Get Dietary Restrictions");
            System.out.println("5. Print All");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter date of birth (YYYY-MM-DD, or type 'NULL' or leave empty if unknown):");
                    String dob = scanner.nextLine();
                    if(dob == "NULL"||dob.isEmpty())
                        System.out.println("Enter age (or type 'NULL' or leave empty if unknown):");
                        String ageInput = scanner.nextLine();
                    System.out.println("Enter gender:");
                    String gender = scanner.nextLine();
                    System.out.println("Enter comments:");
                    String comments = scanner.nextLine();
                    if (ageInput.equalsIgnoreCase("NULL") || ageInput.isEmpty()) {
                        setBasicInfoUsingDateofBirth(firstName, lastName, dob, gender, comments);
                    } else {
                        int age = Integer.parseInt(ageInput);
                        setBasicInfoUsingAge(firstName, lastName, age, gender, comments);
                    }
                    break;
                case 2:
                    System.out.println("Enter dietary restrictions (abbreviations, eg: AVML, MOML):");
                    String[] restrictions = scanner.nextLine().split(",");
                    Set<DisasterVictim.DietaryRestriction> dietaryRestrictionSet = new HashSet<>();
                    for (String restriction : restrictions) {
                        dietaryRestrictionSet.add(DisasterVictim.DietaryRestriction.valueOf(restriction.trim()));
                    }
                    setDietaryRestrictions(dietaryRestrictionSet);
                    break;
                case 3:
                    System.out.println(getBasicInfo());
                    break;
                case 4:
                    System.out.println("Dietary Restrictions: " + getDietaryRestrictions());
                    break;
                case 5:
                    printAllVictimsInfo();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    /**
     * Main method to start the DisasterVictimImplementation program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        DisasterVictimImplementation victim = new DisasterVictimImplementation();
        victim.run();
    }
}
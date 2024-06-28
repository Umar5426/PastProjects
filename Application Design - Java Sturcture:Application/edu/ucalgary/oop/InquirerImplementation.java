package edu.ucalgary.oop;

import java.util.*;

public class InquirerImplementation implements InquirerInterface {
    private List<Inquirer> inquirerList; // List to store Inquirer objects
    private List<String> interactionLog; // List to store interaction logs
    private DatabaseManager dbManager; // Instance of DatabaseManager for database operations

    // Constructor
    public InquirerImplementation() {
        inquirerList = new ArrayList<>(); // Initialize the list of inquirers
        interactionLog = new ArrayList<>(); // Initialize the interaction log
        dbManager = new DatabaseManager(); // Initialize the DatabaseManager instance
    }

    // Method to add an inquirer to the list
    public void addInquirer(Inquirer inquirer) {
        inquirerList.add(inquirer);
    }

    // Method to retrieve and print all inquirer information from the database
    public void printAllInquirersInfoFromDB() {
        dbManager.queryInquirer(); // Query the database for inquirer information using the existing dbManager
    }

    // Method to log an interaction
    @Override
    public void logInteraction(String interactionDetails) {
        System.out.println("Logged Interaction: " + interactionDetails);
        interactionLog.add(interactionDetails); // Add the interaction to the log
    }

    // Method to get the interaction log
    @Override
    public List<String> getInteractionLog() {
        return interactionLog; // Return the interaction log
    }

    // Method to log a query
    @Override
    public void logQuery(String query) {
        System.out.println("Logged Query: " + query);
    }

    // Method to search by name
    @Override
    public List<String> searchByName(String query) {
        return new ArrayList<>(); // Placeholder implementation for search
    }

    // Main method to run the program
    public static void main(String[] args) {
        InquirerImplementation inquirer = new InquirerImplementation(); // Create an instance of InquirerImplementation
        Scanner scanner = new Scanner(System.in); // Create a scanner for user input

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Log Interaction");
            System.out.println("2. Get Interaction Log");
            System.out.println("3. Log Query");
            System.out.println("4. Search by Name");
            System.out.println("5. Print All Inquirer Info from DB");
            System.out.println("6. Exit");

            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter interaction details: ");
                    String interactionDetails = scanner.nextLine();
                    inquirer.logInteraction(interactionDetails);
                    break;
                case 2:
                    List<String> interactionLog = inquirer.getInteractionLog();
                    System.out.println("Interaction Log:");
                    for (String log : interactionLog) {
                        System.out.println(log);
                    }
                    break;
                case 3:
                    System.out.print("Enter query: ");
                    String query = scanner.nextLine();
                    inquirer.logQuery(query);
                    break;
                case 4:
                    System.out.print("Enter search query: ");
                    String searchQuery = scanner.nextLine();
                    List<String> searchResults = inquirer.searchByName(searchQuery);
                    System.out.println("Search Results:");
                    for (String result : searchResults) {
                        System.out.println(result);
                    }
                    break;
                case 5:
                    System.out.println("Printing All Inquirer Info from DB:");
                    inquirer.printAllInquirersInfoFromDB();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
            System.out.println();
        }
    }
}
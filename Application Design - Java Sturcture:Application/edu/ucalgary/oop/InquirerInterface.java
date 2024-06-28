package edu.ucalgary.oop;

import java.util.List;

public interface InquirerInterface {
    /**
     * Logs an interaction with the inquirer.
     * 
     * @param interactionDetails Details of the interaction to be logged.
     */
    void logInteraction(String interactionDetails);

    /**
     * Retrieves the interaction log of the inquirer.
     * 
     * @return List containing the interaction log entries.
     */
    List<String> getInteractionLog();

    /**
     * Logs a query made by the inquirer.
     * 
     * @param query The query made by the inquirer to be logged.
     */
    void logQuery(String query);

    /**
     * Searches for inquirers by name.
     * 
     * @param query The name to search for.
     * @return List of inquirers matching the provided name.
     */
    List<String> searchByName(String query);
}

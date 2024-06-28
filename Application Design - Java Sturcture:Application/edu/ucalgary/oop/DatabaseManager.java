package edu.ucalgary.oop;

import java.sql.*;

public class DatabaseManager {
    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/ensf380project";
    private static final String USERNAME = "oop";
    private static final String PASSWORD = "ucalgary";

    /**
     * Establishes a connection to the database.
     *
     * @return Connection object representing the database connection
     */
    public static Connection connect() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
    }

    /**
     * Closes the database connection, statement, and result set.
     *
     * @param connection Connection object representing the database connection
     * @param statement  Statement object for executing SQL queries
     * @param resultSet  ResultSet object containing the results of a SQL query
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.err.println("Error closing database resources: " + e.getMessage());
        }
    }

    /**
     * Inserts a new record into the INQUIRER table.
     *
     * @param firstName   First name of the inquirer
     * @param lastName    Last name of the inquirer
     * @param phoneNumber Phone number of the inquirer
     */
    public static void insertInquirer(String firstName, String lastName, String phoneNumber) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connect();
            String query = "INSERT INTO INQUIRER (firstName, lastName, phoneNumber) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phoneNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting record into INQUIRER table: " + e.getMessage());
        } finally {
            close(connection, statement, null);
        }
    }

    /**
     * Queries the INQUIRER table and prints the results.
     */
    public void queryInquirer() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connect();
            statement = connection.createStatement();
            String query = "SELECT * FROM INQUIRER";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("phoneNumber");
                System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName + ", Phone Number: " + phoneNumber);
            }
        } catch (SQLException e) {
            System.err.println("Error querying INQUIRER table: " + e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
    }
}

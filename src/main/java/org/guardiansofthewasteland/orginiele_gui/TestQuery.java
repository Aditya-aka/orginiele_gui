package org.guardiansofthewasteland.orginiele_gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestQuery {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Get the connection from the utility class
            connection = DatabaseConnect.getConnection();

            if (connection != null) {
                System.out.println("Connection established!");

                // Create a statement and execute a query
                Statement statement = connection.createStatement();
                String query = "SELECT Container_ID, Locatie, Capaciteit FROM Container";

                ResultSet resultSet = statement.executeQuery(query);

                // Display the results
                System.out.printf("%-15s %-30s %-15s%n", "Container_ID", "Locatie", "Capaciteit");
                System.out.println("-------------------------------------------------------------");

                while (resultSet.next()) {
                    int containerId = resultSet.getInt("Container_ID");
                    String locatie = resultSet.getString("Locatie");
                    int capaciteit = resultSet.getInt("Capaciteit");

                    System.out.printf("%-15d %-30s %-15d%n", containerId, locatie, capaciteit);
                }

                // Close resources
                resultSet.close();
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("SQL query failed.");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

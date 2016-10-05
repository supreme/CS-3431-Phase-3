package org.cs3431;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all of the phase 3 queries.
 * @author Stephen Andrews
 * @since 10/4/16
 */
public class Query {

    /**
     * The SQL connector instance.
     */
    SQLConnector connector;

    /**
     * Constructs a query object.
     * @param connector The SQL connector.
     */
    public Query(SQLConnector connector) {
        this.connector = connector;
    }

    /**
     * Question 1.
     * Reports provider information for a given provider ID.
     */
    public void reportProviderInfo(int providerID) {
        try {
            Statement stmt = connector.getCon().createStatement();
            String query = "SELECT * FROM provider p WHERE p.providerID = " + providerID;
            ResultSet results = stmt.executeQuery(query);
            while (results.next()) {
                String firstName = results.getString("FirstName");
                String lastName = results.getString("LastName");
                System.out.println("ProviderID: " + providerID);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
            }

            query = "SELECT * FROM ProviderTitle pt WHERE pt.providerID = " + providerID;
            results = stmt.executeQuery(query);
            List<String> titles = new ArrayList<>();
            while (results.next()) {
                titles.add(results.getString("Acronym"));
            }
            System.out.println("Titles: " + titles.toString());

            query = "SELECT LocationName " +
                    "FROM Location l, Office o WHERE o.providerID = " + providerID +
                    " AND o.locationID = l.locationID";
            results = stmt.executeQuery(query);
            List<String> officeNames = new ArrayList<>();
            while (results.next()) {
                officeNames.add(results.getString("LocationName"));
            }
            System.out.println("Office Location: " + officeNames.toString());

            results.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package org.cs3431;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Stephen Andrews
 * @since 10/4/16
 */
public class SQLConnector {

    /**
     * The SQL host name.
     */
    private static final String HOST = "oracle.wpi.edu";

    /**
     * SQL connection interface.
     */
    private Connection con;

    /**
     * Username and password for person connecting to database.
     */
    private String user;
    private String pass;

    /**
     * Construct SQL connector.
     * @param user The user's SQL username.
     * @param pass The user's SQL password.
     */
    public SQLConnector(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    /**
     * Establishes a connection to the database with the supplied
     * username and password.
     * @return The connection object.
     */
    public void openConnection() {
        Properties props = new Properties();
        props.put("user", this.user);
        props.put("password", this.pass);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Attempting to establish connection...");
        String conString = "jdbc:oracle:thin:@" + HOST + ":1521:orcl";
        try {
            con = DriverManager.getConnection(conString, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Successfully established database connection!");
    }

    /**
     * Gets the connection object.
     * @return The SQL connection.
     */
    public Connection getCon() {
        return con;
    }
}


package ecivil.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String url = "jdbc:derby://localhost";
    private static String databaseName = "eCivilDB";
    private static int port = 1527;
    private static String username = null;
    private static String password = null;

    /**
     * Attempts to establish a database connection
     *
     * @return a connection to the database
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url + ":" + port + "/" + databaseName, username, password);
    }
}

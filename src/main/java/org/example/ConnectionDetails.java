package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetails {

    public static final String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String URL = "jdbc:mysql://localhost:3306/truck_management";

    public static final String USERNAME = "root";

    public static final String PASSWORD = "rootroot";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(LOAD_DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

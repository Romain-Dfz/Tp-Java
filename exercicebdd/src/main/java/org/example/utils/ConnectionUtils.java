package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getMySQLConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/votre_base_de_donnees";
        String userName = "root";
        String password = "test";
        return DriverManager.getConnection(url,userName,password);
    }
}

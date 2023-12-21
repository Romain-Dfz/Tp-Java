package org.example.util;

import org.example.DAO.LieuDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Ihm.java
public class Ihm {
    private LieuDAO lieuDAO;

    public Ihm() {
        try {
            Connection connection = createConnection();
            lieuDAO = new LieuDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        
    }

    private Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/billet";
        String user = "root";
        String password = "test";
        return DriverManager.getConnection(url, user, password);
    }
}

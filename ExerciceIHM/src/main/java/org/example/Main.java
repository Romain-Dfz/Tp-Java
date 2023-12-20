package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ihm_test";

        try {
            Connection connection = DriverManager.getConnection(url,"root","test");
            if (connection != null){
                System.out.println("connexion ok");
            }else {
                System.out.println("connexion ok !!!");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
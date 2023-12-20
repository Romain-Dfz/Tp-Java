package org.example.banque.dao;

import org.example.banque.model.Client;
import org.example.banque.model.CompteBancaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CompteBancaireDAO {

    public static List<CompteBancaire> recupererComptesParClient(String identifiantClient) {
        return null;
    }
    public void insererClient(Client client) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Connection String = null;
            connection =
                    String;
            String sql = "INSERT INTO compte_bancaire (solde, clientIdentifiant) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, 0.0);
            preparedStatement.setString(2, client.getIdentifiant());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement);
        }
    }
    private void closeResources(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

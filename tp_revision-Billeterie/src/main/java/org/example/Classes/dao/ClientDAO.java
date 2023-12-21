package org.example.Classes.dao;

import org.example.Classes.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    public void addClient(Client client) throws SQLException {
        String query = "INSERT INTO client (nom, prenom, email) VALUES (?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, client.getNom());
            pst.setString(2, client.getPrenom());
            pst.setString(3, client.getEmail());
            pst.executeUpdate();
        }
    }

    public void updateClient(Client client) throws SQLException {
        String query = "UPDATE client SET prenom=?, email=? WHERE nom=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, client.getPrenom());
            pst.setString(2, client.getEmail());
            pst.setString(3, client.getNom());
            pst.executeUpdate();
        }
    }

    public void deleteClient(String email) throws SQLException {
        String query = "DELETE FROM client WHERE email=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, email);
            pst.executeUpdate();
        }
    }

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        try (PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                Client client = new Client(nom, prenom, email);
                clients.add(client);
            }
        }
        return clients;
    }
}

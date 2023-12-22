package org.example.Classes.dao;

import org.example.Classes.model.Lieu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LieuDAO {
    private int id;
    private String nom;
    private String adresse;
    private Integer capacite;
    private Connection connection;

    public LieuDAO(int id, String nom, String adresse, Integer capacite, Connection connection) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.capacite = capacite;
        this.connection = connection;
    }

    public void addLieu(String nom, String adresse, Integer capacite) throws SQLException {
        String query = "INSERT INTO lieu (nom, adresse, capacite) VALUES (?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, nom);
            pst.setString(2, adresse);
            pst.setInt(3, capacite);
            pst.executeUpdate();

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Échec de la récupération de l'ID après l'insertion dans la table Lieu.");
                }
            }
        }
    }

    public void updateLieu(int id, Lieu lieu) throws SQLException {
        String query = "UPDATE lieu SET nom=?, adresse=?, capacite=? WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, lieu.getNom());
            pst.setString(2, lieu.getAdresse());
            pst.setInt(3, lieu.getCapacite());
            pst.setInt(4, id);

            pst.executeUpdate();
        }
    }

    public void deleteLieu(int id) throws SQLException {
        String query = "DELETE FROM lieu WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public List<Lieu> getAllLieus() throws SQLException {
        List<Lieu> lieux = new ArrayList<>();
        String query = "SELECT * FROM lieu";
        try (PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                int capacite = rs.getInt("capacite");
                Lieu lieu = new Lieu(nom, adresse, capacite);
                lieu.setId(id);
                lieux.add(lieu);
            }
        }
        return lieux;
    }

    public Lieu getLieuByName(String lieuNom) {
        return null;
    }
}

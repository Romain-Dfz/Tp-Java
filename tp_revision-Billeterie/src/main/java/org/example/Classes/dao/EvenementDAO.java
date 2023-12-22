package org.example.Classes.dao;

import org.example.Classes.model.Evenement;
import org.example.Classes.model.Lieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvenementDAO {

    private Connection connection;

    public EvenementDAO(Connection connection) {
        this.connection = connection;
    }

    public void addEvenement(Evenement evenement) throws SQLException {
        String query = "INSERT INTO evenement (nom, date, heure, lieu_nom, prix, nbr_billet_vendu) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, evenement.getNom());
            pst.setDate(2, new java.sql.Date(evenement.getDate().getTime()));
            pst.setString(3, evenement.getHeure());
            pst.setString(4, evenement.getLieu().getNom());
            pst.setFloat(5, evenement.getPrix());
            pst.setInt(6, evenement.getNbrBilletVendu());
            pst.executeUpdate();
        }
    }

    public void updateEvenement(Evenement evenement) throws SQLException {
        String query = "UPDATE evenement SET date=?, heure=?, lieu_nom=?, prix=?, nbr_billet_vendu=? WHERE nom=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setDate(1, new java.sql.Date(evenement.getDate().getTime()));
            pst.setString(2, evenement.getHeure());
            pst.setString(3, evenement.getLieu().getNom());
            pst.setFloat(4, evenement.getPrix());
            pst.setInt(5, evenement.getNbrBilletVendu());
            pst.setString(6, evenement.getNom());
            pst.executeUpdate();
        }
    }

    public void deleteEvenement(String nom) throws SQLException {
        String query = "DELETE FROM evenement WHERE nom=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, nom);
            pst.executeUpdate();
        }
    }

    public List<Evenement> getAllEvenements() throws SQLException {
        List<Evenement> evenements = new ArrayList<>();
        String query = "SELECT * FROM evenement";
        try (PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                String nom = rs.getString("nom");
                java.util.Date date = rs.getDate("date");
                String heure = rs.getString("heure");
                String lieuNom = rs.getString("lieu_nom");
                float prix = rs.getFloat("prix");
                int nbrBilletVendu = rs.getInt("nbr_billet_vendu");

                int id = 0;
                String adresse = null;
                Integer capacite = null;
                Lieu lieu = new LieuDAO(id, nom, adresse, capacite, connection).getLieuByName(lieuNom);

                Evenement evenement = new Evenement(nom, date, heure, prix, lieu);
                evenement.setNbrBilletVendu(nbrBilletVendu);

                evenements.add(evenement);
            }
        }
        return evenements;
    }
}

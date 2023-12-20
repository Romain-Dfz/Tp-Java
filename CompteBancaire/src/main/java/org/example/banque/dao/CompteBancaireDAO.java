package org.example.banque.dao;

import com.banque.model.CompteBancaire;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteBancaireDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/banque";
    private static final String UTILISATEUR = "votre_nom_utilisateur";
    private static final String MOT_DE_PASSE = "votre_mot_de_passe";

    public static List<com. banque.model.CompteBancaire> recupererComptesParClient(String identifiantClient) {
        List<com.banque.model.CompteBancaire> comptes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE)) {
            String sql = "SELECT * FROM compte_bancaire WHERE client_identifiant = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, identifiantClient);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        com.banque.model.CompteBancaire compte = new com.banque.model.CompteBancaire();
                        compte.setId(resultSet.getInt("id"));
                        compte.setSolde(resultSet.getDouble("solde"));
                        // Set other properties...
                        comptes.add(compte);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comptes;
    }
}

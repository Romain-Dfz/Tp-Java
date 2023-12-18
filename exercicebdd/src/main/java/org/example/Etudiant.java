package org.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private int classe;
    private Date dateDiplome;

    public Etudiant(String nom, String prenom, int classe, Date dateDiplome) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.dateDiplome = dateDiplome;
    }

    public static void deleteEtudiantByNomPrenom(Connection connection, String nomOuPrenomASupprimer) {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getClasse() {
        return classe;
    }

    public Date getDateDiplome() {
        return dateDiplome;
    }

    public static void addEtudiant(Connection connection, Etudiant etudiant) {
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO etudiant (nom, prenom, classe, date_diplome) VALUES (?, ?, ?, ?)")) {
                preparedStatement.setString(1, etudiant.getNom());
                preparedStatement.setString(2, etudiant.getPrenom());
                preparedStatement.setInt(3, etudiant.getClasse());
                preparedStatement.setDate(4, etudiant.getDateDiplome());
                preparedStatement.executeUpdate();
                System.out.println("Étudiant ajouté avec succès !");

                // Afficher tous les étudiants après l'ajout
                displayAllEtudiants(connection);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'étudiant : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteEtudiantById(Connection connection, int etudiantId) {
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM etudiant WHERE id = ?")) {
                preparedStatement.setInt(1, etudiantId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Étudiant supprimé avec succès !");
                } else {
                    System.out.println("Aucun étudiant trouvé avec l'ID spécifié.");
                }

                // Afficher tous les étudiants après la suppression
                displayAllEtudiants(connection);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'étudiant : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void displayAllEtudiants(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM etudiant");
            System.out.println("Liste des étudiants :");
            System.out.println("ID\tNom\tPrénom\tClasse\tDate de diplôme");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" +
                        resultSet.getString("nom") + "\t" +
                        resultSet.getString("prenom") + "\t" +
                        resultSet.getInt("classe") + "\t" +
                        resultSet.getDate("date_diplome"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des étudiants : " + e.getMessage());
            e.printStackTrace();
        }
    }
}

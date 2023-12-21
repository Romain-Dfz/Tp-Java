package org.example.model;
import org.example.DAO.LieuDAO;
import org.example.model.Lieu;

import java.sql.*;
import java.util.Scanner;

public class BilletterieApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/billet";
    private static final String USER = "root";
    private static final String PASSWORD = "test";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            createTables(connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. CRUD Lieux");
                System.out.println("2. CRUD Clients");
                System.out.println("0. Quitter");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        performLieuCRUD(connection, scanner);
                        break;
                    case 2:
                        performClientCRUD(connection, scanner);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void performLieuCRUD(Connection connection, Scanner scanner) throws SQLException {
        LieuDAO lieuDAO = new LieuDAO(connection);

        while (true) {
            System.out.println("1. Ajouter Lieu");
            System.out.println("2. Afficher Lieux");
            System.out.println("3. Mettre à jour Lieu");
            System.out.println("4. Supprimer Lieu");
            System.out.println("0. Retourner");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nom du lieu : ");
                    String nom = scanner.next();
                    System.out.println("Adresse du lieu : ");
                    String adresse = scanner.next();
                    System.out.println("Capacité du lieu : ");
                    int capacite = scanner.nextInt();

                    Lieu lieu = new Lieu(nom, adresse, capacite);
                    lieuDAO.addLieu(lieu);
                    System.out.println("Lieu ajouté avec succès!");
                    break;
                case 2:
                    System.out.println("Liste des Lieux : ");
                    lieuDAO.getAllLieus().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("ID du lieu à mettre à jour : ");
                    int lieuId = scanner.nextInt();
                    Lieu existingLieu = lieuDAO.getLieuById(lieuId);
                    if (existingLieu != null) {
                        System.out.println("Nouveau nom : ");
                        existingLieu.setNom(scanner.next());
                        System.out.println("Nouvelle adresse : ");
                        existingLieu.setAdresse(scanner.next());
                        System.out.println("Nouvelle capacité : ");
                        existingLieu.setCapacite(scanner.nextInt());

                        lieuDAO.updateLieu(existingLieu);
                        System.out.println("Lieu mis à jour avec succès!");
                    } else {
                        System.out.println("Lieu introuvable.");
                    }
                    break;
                case 4:
                    System.out.println("ID du lieu à supprimer : ");
                    int deleteId = scanner.nextInt();
                    lieuDAO.deleteLieu(deleteId);
                    System.out.println("Lieu supprimé avec succès!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
    }

    private static <ClientDAO> void performClientCRUD(Connection connection, Scanner scanner) throws SQLException {
        ClientDAO clientDAO = new ClientDAO(connection);

        while (true) {
            System.out.println("1. Ajouter Client");
            System.out.println("2. Afficher Clients");
            System.out.println("3. Mettre à jour Client");
            System.out.println("4. Supprimer Client");
            System.out.println("0. Retourner");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nom du client : ");
                    String nom = scanner.next();
                    System.out.println("Prénom du client : ");
                    String prenom = scanner.next();
                    System.out.println("Email du client : ");
                    String email = scanner.next();

                    Client client = new Client(nom, prenom, email);
                    clientDAO.clone(client);
                    System.out.println("Client ajouté avec succès!");
                    break;
                case 2:
                    System.out.println("Liste des Clients : ");
                    clientDAO.getAllClients().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("ID du client à mettre à jour : ");
                    int clientId = scanner.nextInt();
                    Client existingClient = clientDAO.getClientById(clientId);
                    if (existingClient != null) {
                        System.out.println("Nouveau nom : ");
                        existingClient.setNom(scanner.next());
                        System.out.println("Nouveau prénom : ");
                        existingClient.setPrenom(scanner.next());
                        System.out.println("Nouvel email : ");
                        existingClient.setEmail(scanner.next());

                        clientDAO.updateClient(existingClient);
                        System.out.println("Client mis à jour avec succès!");
                    } else {
                        System.out.println("Client introuvable.");
                    }
                    break;
                case 4:
                    System.out.println("ID du client à supprimer : ");
                    int deleteClientId = scanner.nextInt();
                    clientDAO.deleteClient(deleteClientId);
                    System.out.println("Client supprimé avec succès!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        String createLieuTableSQL = "CREATE TABLE IF NOT EXISTS lieu (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nom VARCHAR(255) NOT NULL," +
                "adresse VARCHAR(255) NOT NULL," +
                "capacite INT NOT NULL" +
                ")";
        try (PreparedStatement pst = connection.prepareStatement(createLieuTableSQL)) {
            pst.executeUpdate();
        }

        String createClientTableSQL = "CREATE TABLE IF NOT EXISTS client (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nom VARCHAR(255) NOT NULL," +
                "prenom VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL" +
                ")";
        try (PreparedStatement pst = connection.prepareStatement(createClientTableSQL)) {
            pst.executeUpdate();
        }

        // Ajoutez d'autres instructions SQL pour créer les tables nécessaires (événements, billets, etc.)
    }
}

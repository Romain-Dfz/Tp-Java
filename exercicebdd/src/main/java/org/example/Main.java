package org.example;

import org.example.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtils.getMySQLConnection();
            if (connection != null) {
                System.out.println("Connexion réussie");

                Scanner scanner = new Scanner(System.in);
                int choix;

                do {
                    System.out.println("Veuillez choisir une option :");
                    System.out.println("1. Ajouter un étudiant");
                    System.out.println("2. Supprimer un étudiant par ID");
                    System.out.println("4. Quitter");
                    System.out.print("Votre choix : ");
                    choix = scanner.nextInt();

                    switch (choix) {
                        case 1:

                            ajouterEtudiant(scanner, connection);
                            break;
                        case 2:

                            supprimerEtudiantParId(scanner, connection);
                            break;
                        case 3:

                            System.out.println("Le programme se termine.");
                            break;
                        default:
                            System.out.println("Option invalide.");
                            break;
                    }
                } while (choix != 4);

            } else {
                System.out.println("La connexion a échoué !!!");
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erreur inattendue : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void ajouterEtudiant(Scanner scanner, Connection connection) {
        System.out.print("Nom: ");
        String nom = scanner.next();
        System.out.print("Prénom: ");
        String prenom = scanner.next();

        int classe = -1;
        while (classe == -1) {
            try {
                System.out.print("Numéro de classe: ");
                classe = scanner.nextInt();
            } catch (Exception e) {
                System.err.println("Veuillez entrer un numéro de classe valide.");
                scanner.nextLine();
            }
        }

        System.out.print("Date de diplôme (AAAA-MM-JJ): ");
        String dateDiplome = scanner.next();
        scanner.nextLine();

        Etudiant etudiant = new Etudiant(nom, prenom, classe, Date.valueOf(dateDiplome));
        Etudiant.addEtudiant(connection, etudiant);
    }

    private static void supprimerEtudiantParId(Scanner scanner, Connection connection) {

        System.out.print("Veuillez entrer l'ID de l'étudiant à supprimer : ");
        int etudiantIdASupprimer = scanner.nextInt();
        Etudiant.deleteEtudiantById(connection, etudiantIdASupprimer);
    }
}

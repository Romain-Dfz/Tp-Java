package org.example.banque.IHM;

import org.example.banque.dao.CompteBancaireDAO;
import org.example.banque.model.Client;
import org.example.banque.model.CompteBancaire;

import java.util.List;
import java.util.Scanner;

public class IHM {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    creerClient();
                    break;
                case 2:
                    afficherComptesClient();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\nMenu :");
        System.out.println("1. Créer un client");
        System.out.println("2. Afficher les comptes d'un client");
        System.out.println("3. Effectuer un dépôt");
        System.out.println("4. Effectuer un retrait");
        System.out.println("5. Quitter");
        System.out.print("Veuillez choisir une option : ");
    }

    private static void creerClient() {
        scanner.nextLine();

        System.out.print("Nom du client : ");
        String nom = scanner.nextLine();

        System.out.print("Prénom du client : ");
        String prenom = scanner.nextLine();

        Client client = new Client(nom, prenom );

        System.out.println("Client créé avec succès !");
    }

    private static void effectuerDepot(CompteBancaire compte) {
        System.out.print("Montant du dépôt : ");
        double montant = scanner.nextDouble();

        compte.effectuerDepot(montant);
        System.out.println("Dépôt effectué avec succès. Nouveau solde : " + compte.getSolde());
    }

    private static void effectuerRetrait(CompteBancaire compte) {
        System.out.print("Montant du retrait : ");
        double montant = scanner.nextDouble();

        compte.effectuerRetrait(montant);
        System.out.println("Retrait effectué avec succès. Nouveau solde : " + compte.getSolde());
    }

    private static void afficherComptesClient() {
        scanner.nextLine();
        System.out.print("Identifiant du client : ");
        String identifiantClient = scanner.nextLine();

        List<CompteBancaire> comptes = CompteBancaireDAO.recupererComptesParClient(identifiantClient);

        if (!comptes.isEmpty()) {
            System.out.println("Comptes du client " + identifiantClient + " :");
            for (CompteBancaire compte : comptes) {
                System.out.println("ID du compte : " + compte.getId() + ", Solde : " + compte.getSolde());
            }
            afficherSousMenuCompte(comptes.get(0));
        } else {
            System.out.println("Aucun compte trouvé pour le client " + identifiantClient);
        }
    }

    private static void afficherSousMenuCompte(CompteBancaire compte) {
        while (true) {
            System.out.println("\nMenu du compte " + compte.getId());
            System.out.println("1. Consulter le solde");
            System.out.println("2. Déposer de l'argent");
            System.out.println("3. Retirer de l'argent");
            System.out.println("4. Revenir au menu principal");
            System.out.print("Veuillez choisir une option : ");

            int choixSousMenu = scanner.nextInt();

            switch (choixSousMenu) {
                case 1:
                    System.out.println("Solde du compte : " + compte.getSolde());
                    break;
                case 2:
                    double montant = 0;
                    compte.effectuerDepot(montant);
                    break;
                case 3:
                    double mont = 0;
                    compte.effectuerRetrait(mont);
                    break;
                case 4:

                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        }
    }
}

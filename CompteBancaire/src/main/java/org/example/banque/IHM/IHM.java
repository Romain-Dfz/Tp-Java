package org.example.banque.IHM;

import com.banque.dao.CompteBancaireDAO;
import com.banque.model.CompteBancaire;

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
                    // Appeler la méthode pour effectuer un dépôt
                    break;
                case 4:
                    // Appeler la méthode pour effectuer un retrait
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
        // Code pour créer un client...
    }

    private static void afficherComptesClient() {
        scanner.nextLine(); // Nettoyer la ligne précédente
        System.out.print("Identifiant du client : ");
        String identifiantClient = scanner.nextLine();

        // Appeler la méthode pour récupérer les comptes du client depuis la base de données
        List<com.banque.model.CompteBancaire> comptes = CompteBancaireDAO.recupererComptesParClient(identifiantClient);

        if (!comptes.isEmpty()) {
            System.out.println("Comptes du client " + identifiantClient + " :");
            for (com.banque.model.CompteBancaire compte : comptes) {
                System.out.println("ID du compte : " + compte.getId() + ", Solde : " + compte.getSolde());
            }

            // Appeler la méthode pour afficher le sous-menu du compte
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
                    // Consulter le solde
                    System.out.println("Solde du compte : " + compte.getSolde());
                    break;
                case 2:
                    // Appeler la méthode pour effectuer un dépôt sur le compte
                    break;
                case 3:
                    // Appeler la méthode pour effectuer un retrait sur le compte
                    break;
                case 4:
                    // Revenir au menu principal
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}

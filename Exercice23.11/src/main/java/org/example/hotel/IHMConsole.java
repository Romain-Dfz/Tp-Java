package org.example.hotel;
import java.util.Scanner;
public class IHMConsole {
    private static Scanner scanner = new Scanner(System.in);

    public static void afficherMenu() {
        System.out.println("Menu :");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Afficher la liste des clients");
        System.out.println("3. Afficher les réservations d'un client");
        System.out.println("4. Ajouter une réservation");
        System.out.println("5. Annuler une réservation");
        System.out.println("6. Afficher la liste des réservations");
        System.out.println("0. Quitter");
    }

    public static void main(String[] args) {
        System.out.println("Bienvenue dans l'application de gestion des réservations d'hôtel.");

        Hotel hotel = new Hotel("Mon Hotel", 20);

        int choix;
        do {
            afficherMenu();
            System.out.print("Veuillez choisir une option : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom du client : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom du client : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Numéro du client : ");
                    String telephone = scanner.nextLine();
                    hotel.ajouterClient(nom, prenom, telephone);
                    break;
                case 2:
                    hotel.afficherListeClients();
                    break;
                case 3:
                    System.out.print("Numéro du client : ");
                    String telClient = scanner.nextLine();
                    hotel.afficherReservationsClient(telClient);
                    break;
                case 4:
                    System.out.print("Numéro du client : ");
                    int idClient = scanner.nextInt();
                    System.out.print("Nombre d'occupants : ");
                    int nbOccupants = scanner.nextInt();
                    hotel.ajouterReservation(idClient, nbOccupants);
                    break;
                case 5:
                    System.out.print("Numéro de réservation : ");
                    int numReservation = scanner.nextInt();
                    hotel.annulerReservation(numReservation);
                    break;
                case 6:
                    hotel.afficherListeReservations();
                    break;
                case 0:
                    System.out.println("Merci d'avoir utilisé notre application. Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }
}

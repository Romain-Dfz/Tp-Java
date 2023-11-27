package org.example.hotel;

// Hotel.java
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nom;
    private List<Chambre> chambres;
    private List<Reservation> reservations;
    private List<Client> clients;

    public Hotel(String nom, int nombreChambres) {
        this.nom = nom;
        this.chambres = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.clients = new ArrayList<>();
        initialiserChambres(nombreChambres);
    }

    private void initialiserChambres(int nombreChambres) {
        for (int i = 1; i <= nombreChambres; i++) {
            chambres.add(new Chambre(i, 100.0, 2)); // Exemple de tarif et de capacité
        }
    }

    public void ajouterClient(String nom, String prenom, String telephone) {
        Client client = new Client(nom, prenom, telephone);
        clients.add(client);
        System.out.println("Client ajouté avec succès.");
    }

    public void afficherListeClients() {
        System.out.println("Liste des clients :");
        for (Client client : clients) {
            System.out.println(client.getId() + ". " + client.getNom() + " " + client.getPrenom());
        }
    }

    public void afficherReservationsClient(String telephone) {
    }

    public void ajouterReservation(int idClient, int nombreOccupants) {
    }

    public void annulerReservation(int numeroReservation) {
    }

    public void afficherListeReservations() {
        System.out.println("Liste des réservations :");
        for (Reservation reservation : reservations) {
            System.out.println(reservation.getNumero() + ". " +
                    reservation.getClient().getNom() + " " + reservation.getClient().getPrenom() +
                    " - Chambre " + reservation.getChambre().getNumero());
        }
    }
}

package org.example.hotel;
public class Reservation {
    private static int count = 1;
    private int numero;
    private boolean validee;
    private Client client;
    private Chambre chambre;

    public Reservation(Client client, Chambre chambre) {
        this.numero = count++;
        this.validee = true;
        this.client = client;
        this.chambre = chambre;
        chambre.setOccupee(true);
    }

    public int getNumero() {
        return numero;
    }

    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public Client getClient() {
        return client;
    }

    public Chambre getChambre() {
        return chambre;
    }
}

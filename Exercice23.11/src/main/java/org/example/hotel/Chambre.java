package org.example.hotel;
public class Chambre {
    private int numero;
    private boolean occupee;
    private double tarif;
    private int capacite;

    public Chambre(int numero, double tarif, int capacite) {
        this.numero = numero;
        this.occupee = false;
        this.tarif = tarif;
        this.capacite = capacite;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOccupee() {
        return occupee;
    }

    public void setOccupee(boolean occupee) {
        this.occupee = occupee;
    }

    public double getTarif() {
        return tarif;
    }

    public int getCapacite() {
        return capacite;
    }
}

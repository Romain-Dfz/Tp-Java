package org.example.banque.model;

import java.util.ArrayList;
import java.util.List;

public class CompteBancaire {
    private int id;
    private double solde;
    private String clientIdentifiant;
    private List<Operation> operations;

    public CompteBancaire(int id, double solde, String clientIdentifiant) {
        this.id = id;
        this.solde = solde;
        this.clientIdentifiant = clientIdentifiant;
        this.operations = new ArrayList<>();
    }

    public CompteBancaire() {

    }

    public int getId() {
        return id;
    }

    public double getSolde() {
        return solde;
    }

    public void effectuerDepot(double montant) {
        if (montant > 0) {
            solde += montant;
            Operation operation = new Operation(OperationType.DEPOT, montant);
            operations.add(operation);
            System.out.println("Dépôt effectué avec succès. Nouveau solde : " + solde);
        } else {
            System.out.println("Montant invalide. Veuillez entrer un montant positif.");
        }
    }

    public void effectuerRetrait(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            Operation operation = new Operation(OperationType.RETRAIT, montant);
            operations.add(operation);
            System.out.println("Retrait effectué avec succès. Nouveau solde : " + solde);
        } else {
            System.out.println("Montant invalide. Veuillez entrer un montant positif et inférieur au solde.");
        }
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setId(int id) {
    }

    public void setSolde(double solde) {
    }
}

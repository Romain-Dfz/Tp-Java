package org.example.banque.model;

import org.example.banque.Operation;
import org.example.banque.OperationType;

import java.util.ArrayList;
import java.util.List;

public class CompteBancaire {
    private static int dernierId = 0;

    private int id;
    private double solde;
    private com.banque.model.Client client;
    private List<Operation> operations;

    public CompteBancaire(com.banque.model.Client client) {
        this.id = ++dernierId;
        this.solde = 0.0;
        this.client = client;
        this.operations = new ArrayList<>();
    }

    // Getters et setters

    public void ajouterOperation(Operation operation) {
        operations.add(operation);
    }

    public void effectuerDepot(double montant) {
        if (montant > 0) {
            solde += montant;
            ajouterOperation(new Operation(OperationType.DEPOT, montant));
        }
    }

    public void effectuerRetrait(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            ajouterOperation(new Operation(OperationType.RETRAIT, montant));
        }
    }

    public String getId() {
        return null;
    }
}

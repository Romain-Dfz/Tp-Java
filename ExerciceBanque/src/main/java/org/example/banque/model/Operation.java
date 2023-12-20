package org.example.banque.model;

import java.util.Date;

public class Operation {
    private OperationType type;
    private double montant;
    private Date date;

    public Operation(OperationType type, double montant) {
        this.type = type;
        this.montant = montant;
        this.date = new Date();
    }
    public OperationType getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }
}

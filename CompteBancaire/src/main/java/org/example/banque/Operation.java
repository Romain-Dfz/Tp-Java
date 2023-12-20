package org.example.banque;
package com.banque.model;

public class Operation {
    private static int dernierNumero = 0;

    private int numero;
    private double montant;
    private OperationType type;

    public Operation(OperationType type, double montant) {
        this.numero = ++dernierNumero;
        this.type = type;
        this.montant = montant;
    }

    // Getters
}

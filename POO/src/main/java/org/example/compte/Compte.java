package org.example.compte;
import java.util.ArrayList;

public abstract class Compte {

    public abstract void retirer(double montant);

    static class Comptes {
        private static int nombreComptes = 0;
        protected int code;
        protected double solde;

        public Comptes() {
            this.code = ++nombreComptes;
            this.solde = 0;
        }
        public void deposer(double montant) {
            this.solde += montant;
        }
        public void retirer(double montant) {
            this.solde -= montant;
        }
        public String toString() {
            return "Compte " + code + " - Solde: " + solde;
        }
    }

    static class CompteSimple extends Compte {
        private final double decouvert;

        public CompteSimple(double decouvert) {
            super();
            this.decouvert = decouvert;
        }
        @Override
        public void retirer(double montant) {
            double solde = 0;
            if (montant <= solde + decouvert) {
            } else {
                System.out.println("Retrait impossible. Dépassement du découvert autorisé.");
            }
        }
        @Override
        public String toString() {
            return super.toString() + " - Découvert autorisé: " + decouvert;
        }
    }

    static class CompteEpargne extends Compte {
        private final double tauxInteret;
        private double solde;

        public CompteEpargne(double tauxInteret) {
            super();
            this.tauxInteret = tauxInteret;
        }

        @Override
        public String toString() {
            return super.toString() + " - Taux d'intérêt: " + tauxInteret;
        }
        @Override
        public void retirer(double montant) {
            
        }
    }

    void depose(double v) {
    }

}

package org.example.personnages;
public class Archer extends Personnage {
    public Archer(String nom) {
        super(nom);
    }

    @Override
    public void personnaliserArme(String arme) {
        if ("arc".equalsIgnoreCase(arme) || "arbalète".equalsIgnoreCase(arme) || "javelot".equalsIgnoreCase(arme)) {
            this.arme = arme;
        } else {
            System.out.println("Arme invalide pour l'archer. Choisissez parmi : arc, arbalète, javelot.");
        }
    }

    @Override
    public String toString() {
        return "Archer{" +
                "nom='" + nom + '\'' +
                ", arme='" + arme + '\'' +
                '}';
    }
}


package org.example.personnages;
public abstract class Personnage {
    protected String nom;
    protected String arme;

    public Personnage(String nom) {
        this.nom = nom;
    }

    public abstract void personnaliserArme(String arme);

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", arme='" + arme + '\'' +
                '}';
    }
}


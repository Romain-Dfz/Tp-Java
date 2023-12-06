package org.example.batiments;
public abstract class Batiment {
    protected String nom;
    protected String style;
    protected int taille;

    public Batiment(String nom) {
        this.nom = nom;
        this.taille = 1;
    }

    public abstract void personnaliserStyle(String style);

    public void personnaliserTaille(int taille) {
        this.taille = Math.max(1, Math.min(taille, 10));
    }

    @Override
    public String toString() {
        return "Batiment{" +
                "nom='" + nom + '\'' +
                ", style='" + style + '\'' +
                ", taille=" + taille +
                '}';
    }
}

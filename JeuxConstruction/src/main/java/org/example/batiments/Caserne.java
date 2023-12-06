package org.example.batiments;
public class Caserne extends Batiment {
    public Caserne(String nom) {
        super(nom);
    }

    @Override
    public void personnaliserStyle(String style) {
        this.style = style;
    }
    @Override
    public void personnaliserTaille(int taille) {
        this.taille = taille;
    }
    @Override
    public String toString() {
        return "Chateau{" +
                "nom='" + nom + '\'' +
                ", style='" + style + '\'' +
                ", taille=" + taille +
                '}';
    }
}


package org.example.batiments;
public class Forge extends Batiment {
    public Forge(String nom) {
        super(nom);
    }

    @Override
    public void personnaliserStyle(String style) {
        this.style = style;
        // Logique spécifique au château pour personnaliser le style
    }

    @Override
    public void personnaliserTaille(int taille) {
        this.taille = taille;
        // Logique spécifique au château pour personnaliser la taille
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

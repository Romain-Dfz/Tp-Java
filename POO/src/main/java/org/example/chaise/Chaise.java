package org.example.chaise;

public class Chaise {
    private int nbPieds;
    private String couleur;
    private String materiaux;

    public Chaise() {
        this.nbPieds = 0;
        this.couleur = "non définie";
        this.materiaux = "non définis";
    }

    public Chaise(int nbPieds, String couleur, String materiaux) {
        this.nbPieds = nbPieds;
        this.couleur = couleur;
        this.materiaux = materiaux;
    }

    @Override
    public String toString() {
        return "Je suis une chaise, avec " + nbPieds + " pieds en " + materiaux + " et de couleur " + couleur;
    }
}


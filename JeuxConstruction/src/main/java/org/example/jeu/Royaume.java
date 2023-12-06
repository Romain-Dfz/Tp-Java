package org.example.jeu;
import org.example.batiments.Batiment;
import org.example.personnages.Personnage;
import java.util.ArrayList;
import java.util.List;

public class Royaume {
    private String nom;
    private List<Batiment> batiments;
    private List<Personnage> personnages;

    public Royaume() {
        this.batiments = new ArrayList<>();
        this.personnages = new ArrayList<>();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void construireBatiment(Batiment batiment) {
        batiments.add(batiment);
    }

    public void recruterPersonnage(Personnage personnage) {
        personnages.add(personnage);
    }

    public List<Batiment> getBatiments() {
        return batiments;
    }

    public List<Personnage> getPersonnages() {
        return personnages;
    }

    @Override
    public String toString() {
        return "Royaume{" +
                "nom='" + nom + '\'' +
                ", batiments=" + batiments +
                ", personnages=" + personnages +
                '}';
    }
}


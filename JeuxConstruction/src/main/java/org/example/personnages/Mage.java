package org.example.personnages;
public class Mage extends Personnage {
    public Mage(String nom) {
        super(nom);
    }

    @Override
    public void personnaliserArme(String arme) {
        if ("bâton".equalsIgnoreCase(arme) || "sceptre".equalsIgnoreCase(arme) || "grimoire".equalsIgnoreCase(arme)) {
            this.arme = arme;
        } else {
            System.out.println("Arme invalide pour le mage. Choisissez parmi : bâton, sceptre, grimoire.");
        }
    }

    @Override
    public String toString() {
        return "Mage{" +
                "nom='" + nom + '\'' +
                ", arme='" + arme + '\'' +
                '}';
    }
}

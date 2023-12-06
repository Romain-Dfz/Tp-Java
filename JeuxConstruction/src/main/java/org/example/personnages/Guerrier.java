package org.example.personnages;
public class Guerrier extends Personnage {
    public Guerrier(String nom) {
        super(nom);
    }

    @Override
    public void personnaliserArme(String arme) {
        if ("épée".equalsIgnoreCase(arme) || "hache".equalsIgnoreCase(arme) || "marteau".equalsIgnoreCase(arme)) {
            this.arme = arme;
        } else {
            System.out.println("Arme invalide pour le guerrier. Choisissez parmi : épée, hache, marteau.");
        }
    }

    @Override
    public String toString() {
        return "Guerrier{" +
                "nom='" + nom + '\'' +
                ", arme='" + arme + '\'' +
                '}';
    }
}

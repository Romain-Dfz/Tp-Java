package org.example.compteurmots;
public class CompteurMots {
    public static void main(String[] args) {
        String phrase = "Ceci est un exemple de phrase pour le compteur de mots.";
        int nombreDeMots = compterMots(phrase);
        System.out.println("Nombre de mots dans la phrase : " + nombreDeMots);
    }
    static int compterMots(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return 0;
        }
        String[] mots = phrase.split("\\s+");

        return mots.length;
    }
}

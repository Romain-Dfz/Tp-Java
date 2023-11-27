package org.example.compteuroccurrencelettre;

public class CompteurOccurrenceLettre {

    public static void main(String[] args) {
        String mot = "pro gamer rainbow";
        char lettreRecherchee = 'r';
        int occurrences = compterOccurrencesLettre(mot, lettreRecherchee);
        System.out.println("Le nombre d'occurrences de la lettre '" + lettreRecherchee + "' dans le mot est : " + occurrences);
    }

    static int compterOccurrencesLettre(String mot, char lettre) {
        if (mot == null || mot.isEmpty()) {
            return 0;
        }

        int occurrences = 0;
        for (char caractere : mot.toCharArray()) {
            if (caractere == lettre) {
                occurrences++;
            }
        }

        return occurrences;
    }
}

package org.example;
import java.util.List;

public class TextAnalyzer {
    public static void main(String[] args) {
        String texte = "Mon texte je note ici n'importe de quoi pour tester mon programme";
        List<String> mots = TextProcessor.preparerDonnees(texte);

        TextProcessor.compterFrequenceMots(mots)
                .forEach((mot, frequence) -> System.out.println(mot + " : " + frequence));

        int longueurMinimale = 5;
        TextProcessor.filtrerMots(mots, longueurMinimale)
                .forEach(mot -> System.out.print(mot + " "));

        TextProcessor.trouverMotsUniques(mots)
                .forEach(mot -> System.out.print(mot + " "));

        int topN = 5;
        TextProcessor.trouverMotsPlusFrequents(mots, topN)
                .forEach(mot -> System.out.print(mot + " "));

        TextProcessor.calculerStatistiquesLongueurMots(mots)
                .forEach(System.out::println);
    }
}

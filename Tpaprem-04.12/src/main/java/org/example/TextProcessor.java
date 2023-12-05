package org.example;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextProcessor {
    public static List<String> preparerDonnees(String texte) {
        String texteNettoye = Normalizer.normalize(texte, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[^a-zA-Z ]", "")
                .toLowerCase();
        return Arrays.asList(texteNettoye.split("\\s+"));
    }

    public static Map<String, Long> compterFrequenceMots(List<String> mots) {
        return mots.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static List<String> filtrerMots(List<String> mots, int longueurMinimale) {
        return mots.stream()
                .filter(mot -> mot.length() > longueurMinimale)
                .collect(Collectors.toList());
    }

    public static List<String> trouverMotsUniques(List<String> mots) {
        return mots.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> trouverMotsPlusFrequents(List<String> mots, int topN) {
        return mots.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> calculerStatistiquesLongueurMots(List<String> mots) {
        double longueurMoyenne = mots.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        int longueurMinimale = mots.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);
        int longueurMaximale = mots.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        return Arrays.asList(
                " Moyenne: " + longueurMoyenne,
                " Min: " + longueurMinimale,
                " Max: " + longueurMaximale
        );
    }
}

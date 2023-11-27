package org.example.wordvountprogram;
import java.util.Scanner;

public class WordCountProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez du texte : ");
        String texte = scanner.nextLine();
        int nombreDeMots = getWordsAmount(texte);
        System.out.println("Le nombre de mots dans le texte est : " + nombreDeMots);
    }
    public static int getWordsAmount(String texte) {
        if (texte == null || texte.trim().isEmpty()) {
            return 0;
        }
        String[] mots = texte.split("\\s+");
        return mots.length;
    }
}

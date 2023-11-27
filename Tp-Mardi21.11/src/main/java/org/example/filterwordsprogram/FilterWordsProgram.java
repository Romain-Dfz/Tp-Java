package org.example.filterwordsprogram;

import java.util.Scanner;

public class FilterWordsProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez des mots aléatoires séparés par un espace : ");
        String motsInput = scanner.nextLine();

        System.out.print("Entrez la longueur minimale pour filtrer les mots : ");
        int minLength = scanner.nextInt();

        String[] mots = motsInput.split("\\s+");

        String[] motsFiltres = filterWordsByLength(minLength, mots);

        System.out.println("Mots filtrés par longueur minimale de " + minLength + " :");
        for (String mot : motsFiltres) {
            System.out.println(mot);
        }
    }
    public static String[] filterWordsByLength(int minLength, String[] mots) {
        int count = 0;
        for (String mot : mots) {
            if (mot.length() >= minLength) {
                count++;
            }
        }
        String[] motsFiltres = new String[count];
        int index = 0;
        for (String mot : mots) {
            if (mot.length() >= minLength) {
                motsFiltres[index++] = mot;
            }
        }

        return motsFiltres;
    }
}

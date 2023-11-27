package org.example.maxvalueprogram;
import java.util.Scanner;

public class MaxValueProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez des nombres entiers séparés par un espace : ");
        String input = scanner.nextLine();
        String[] numberStrings = input.split("\\s+");
        int[] intArray = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            intArray[i] = Integer.parseInt(numberStrings[i]);
        }
        int maxValue = findMaxIntInArray(intArray);
        System.out.println("La valeur maximale du tableau est : " + maxValue);
    }
    public static int findMaxIntInArray(int[] intArray) {
        if (intArray.length == 0) {
            throw new IllegalArgumentException("Le tableau ne doit pas être vide.");
        }

        int max = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            }
        }
        return max;
    }
}

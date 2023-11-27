package org.example.verificateuranagramme;
import java.util.Arrays;

public class VerificateurAnagramme {

    public static void main(String[] args) {
        String mot1 = "romain";
        String mot2 = "marion";

        if (sontAnagrammes(mot1, mot2)) {
            System.out.println(mot1 + " et " + mot2 + " sont des anagrammes.");
        } else {
            System.out.println(mot1 + " et " + mot2 + " ne sont pas des anagrammes.");
        }
    }

    static boolean sontAnagrammes(String mot1, String mot2) {
        if (mot1.length() != mot2.length()) {
            return false;
        }
        char[] mot1Array = mot1.toCharArray();
        char[] mot2Array = mot2.toCharArray();
        Arrays.sort(mot1Array);
        Arrays.sort(mot2Array);

        return Arrays.equals(mot1Array, mot2Array);
    }
}

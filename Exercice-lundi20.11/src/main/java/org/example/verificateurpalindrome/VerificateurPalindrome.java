package org.example.verificateurpalindrome;
public class VerificateurPalindrome {

    public static void main(String[] args) {
        String mot1 = "radar";
        String mot2 = "michel";

        if (estPalindrome(mot1)) {
            System.out.println(mot1 + " est un palindrome.");
        } else {
            System.out.println(mot1 + " n'est pas un palindrome.");
        }

        if (estPalindrome(mot2)) {
            System.out.println(mot2 + " est un palindrome.");
        } else {
            System.out.println(mot2 + " n'est pas un palindrome.");
        }
    }
    static boolean estPalindrome(String mot) {
        String motSansEspaces = mot.replaceAll("\\s", "").toLowerCase();

        int longueur = motSansEspaces.length();
        for (int i = 0; i < longueur / 2; i++) {
            if (motSansEspaces.charAt(i) != motSansEspaces.charAt(longueur - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

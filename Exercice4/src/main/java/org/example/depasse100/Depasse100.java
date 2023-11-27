package org.example.depasse100;

public class Depasse100 {

    public static void main(String[] args) {
        int somme = 0;
        int N = 0;
        while (somme <= 100) {
            N++;
            somme += N;
        }
        System.out.println("Le premier nombre entier N tel que la somme de 1 à N dépasse strictement 100 est : " + N);
    }
}

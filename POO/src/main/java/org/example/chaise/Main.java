package org.example.chaise;
import org.example.chaise.Chaise;

public class Main {
    public static void main(String[] args) {
        Chaise chaise1 = new Chaise();
        Chaise chaise2 = new Chaise(4, "Bleu", "Bois");
        Chaise chaise3 = new Chaise(4, "Blanche", "Métal");
        Chaise chaise4 = new Chaise(1, "Transparente", "Plexiglass");

        System.out.println(chaise1);
        System.out.println(chaise2);
        System.out.println(chaise3);
        System.out.println(chaise4);
    }

}

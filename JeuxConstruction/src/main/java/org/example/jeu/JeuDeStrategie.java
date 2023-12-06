package org.example.jeu;

import org.example.batiments.Batiment;
import org.example.batiments.Caserne;
import org.example.batiments.Chateau;
import org.example.batiments.Forge;
import org.example.personnages.Archer;
import org.example.personnages.Guerrier;
import org.example.personnages.Mage;
import org.example.personnages.Personnage;
import java.util.Scanner;

public class JeuDeStrategie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Royaume royaume = creerRoyaume(scanner);
        System.out.println("Bienvenue dans le jeu de stratégie, " + royaume.getNom() + "!");

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Construire un bâtiment");
            System.out.println("2. Recruter un personnage");
            System.out.println("3. Afficher le royaume");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    construireBatiment(royaume, scanner);
                    break;
                case 2:
                    recruterPersonnage(royaume, scanner);
                    break;
                case 3:
                    afficherRoyaume(royaume);
                    break;
                case 4:
                    System.out.println("Merci d'avoir joué !");
                    System.exit(0);
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }
        }
    }

    private static Royaume creerRoyaume(Scanner scanner) {
        System.out.print("Donnez un nom à votre royaume : ");
        String nomRoyaume = scanner.nextLine();

        Royaume royaume = new Royaume();
        royaume.setNom(nomRoyaume);

        return royaume;
    }

    private static void construireBatiment(Royaume royaume, Scanner scanner) {
        System.out.println("\nChoisissez le type de bâtiment :");
        System.out.println("1. Château");
        System.out.println("2. Caserne");
        System.out.println("3. Forge");

        System.out.print("Votre choix : ");
        int choixBatiment = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Donnez un nom au bâtiment : ");
        String nomBatiment = scanner.nextLine();

        Batiment batiment = null;

        switch (choixBatiment) {
            case 1:
                batiment = new Chateau(nomBatiment);
                break;
            case 2:
                batiment = new Caserne(nomBatiment);
                break;
            case 3:
                batiment = new Forge(nomBatiment);
                break;
            default:
                System.out.println("Option invalide. Retour au menu principal.");
                return;
        }

        System.out.print("Choisissez le style du bâtiment (bois, pierre, or) : ");
        String styleBatiment = scanner.nextLine();
        batiment.personnaliserStyle(styleBatiment);

        System.out.print("Choisissez la taille du bâtiment (de 1 à 10) : ");
        int tailleBatiment = scanner.nextInt();
        scanner.nextLine();
        batiment.personnaliserTaille(tailleBatiment);

        royaume.construireBatiment(batiment);
        System.out.println("Le bâtiment a été construit avec succès !");
    }

    private static void recruterPersonnage(Royaume royaume, Scanner scanner) {
        System.out.println("\nChoisissez le type de personnage :");
        System.out.println("1. Guerrier");
        System.out.println("2. Archer");
        System.out.println("3. Mage");

        System.out.print("Votre choix : ");
        int choixPersonnage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Donnez un nom au personnage : ");
        String nomPersonnage = scanner.nextLine();

        Personnage personnage = null;

        switch (choixPersonnage) {
            case 1:
                personnage = new Guerrier(nomPersonnage);
                break;
            case 2:
                personnage = new Archer(nomPersonnage);
                break;
            case 3:
                personnage = new Mage(nomPersonnage);
                break;
            default:
                System.out.println("Option invalide. Retour au menu principal.");
                return;
        }
        if (personnage instanceof Guerrier) {
            System.out.println("Choisissez l'arme du guerrier : épée, hache, marteau.");
        } else if (personnage instanceof Archer) {
            System.out.println("Choisissez l'arme de l'archer : arc, arbalète, javelot.");
        } else if (personnage instanceof Mage) {
            System.out.println("Choisissez l'arme du mage : bâton, sceptre, grimoire.");
        }

        System.out.print("Votre choix d'arme : ");
        String armePersonnage = scanner.nextLine();
        personnage.personnaliserArme(armePersonnage);

        royaume.recruterPersonnage(personnage);
        System.out.println("Le personnage a été recruté avec succès !");
    }

    private static void afficherRoyaume(Royaume royaume) {
        System.out.println("\n--- Royaume ---");
        System.out.println("Nom : " + royaume.getNom());
        System.out.println("Bâtiments :");
        for (Batiment batiment : royaume.getBatiments()) {
            System.out.println(batiment);
        }
        System.out.println("Personnages :");
        for (Personnage personnage : royaume.getPersonnages()) {
            System.out.println(personnage);
        }
        System.out.println("---------------");
    }
}

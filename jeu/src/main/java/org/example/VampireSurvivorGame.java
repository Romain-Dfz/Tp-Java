package org.example;
import java.util.Random;
import java.util.Scanner;

public class VampireSurvivorGame {

    public static void main(String[] args) {
        jouerVampireSurvivor();
    }

    public static void jouerVampireSurvivor() {
        Scanner scanner = new Scanner(System.in);
        Joueur joueur = new Joueur();

        System.out.println("Bienvenue dans le jeu Vampire Survivor!");
        System.out.println("Vous vous réveillez dans un monde infesté de vampires. Votre objectif est de survivre.");

        while (joueur.estEnVie()) {
            afficherStatistiques(joueur);

            System.out.println("\nQue voulez-vous faire?");
            System.out.println("1. Chercher des provisions");
            System.out.println("2. Trouver un abri");
            System.out.println("3. Affronter un vampire");
            System.out.println("4. Quitter le jeu");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    chercherProvisions(joueur);
                    break;
                case 2:
                    trouverAbri(joueur);
                    break;
                case 3:
                    affronterVampire(joueur);
                    break;
                case 4:
                    System.out.println("Vous quittez le jeu. Merci d'avoir joué!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez choisir une option valide.");
            }

            gererEvenementAleatoire(joueur);
        }

        System.out.println("Game Over. Vous n'avez pas survécu aux vampires. Merci d'avoir joué!");
        scanner.close();
    }

    private static void afficherStatistiques(Joueur joueur) {
        System.out.println("\n--- Statistiques ---");
        System.out.println("Santé: " + joueur.getSante());
        System.out.println("Force: " + joueur.getForce());
    }

    private static void chercherProvisions(Joueur joueur) {
        System.out.println("Vous cherchez des provisions et trouvez de la nourriture.");
        joueur.gagnerSante(10);
    }

    private static void trouverAbri(Joueur joueur) {
        System.out.println("Vous trouvez un abri sûr pour la nuit.");
        joueur.gagnerSante(5);
    }

    private static void affronterVampire(Joueur joueur) {
        Random random = new Random();
        int forceVampire = random.nextInt(20) + 1;

        System.out.println("Vous affrontez un vampire avec une force de " + forceVampire + ".");

        if (joueur.getForce() > forceVampire) {
            System.out.println("Vous avez vaincu le vampire et gagné de l'expérience!");
            joueur.gagnerForce(5);
        } else {
            System.out.println("Le vampire était trop fort. Vous perdez de la santé.");
            joueur.perdreSante(10);
        }
    }

    private static void gererEvenementAleatoire(Joueur joueur) {
        Random random = new Random();
        int evenement = random.nextInt(3); // 0, 1, 2

        switch (evenement) {
            case 0:
                System.out.println("Rien d'extraordinaire ne se passe.");
                break;
            case 1:
                System.out.println("Vous trouvez un artefact mystérieux qui améliore votre force!");
                joueur.gagnerForce(3);
                break;
            case 2:
                System.out.println("Un vampire vous attaque pendant votre sommeil. Vous perdez de la santé.");
                joueur.perdreSante(15);
                break;
        }
    }
}

class Joueur {
    private int sante;
    private int force;

    public Joueur() {
        this.sante = 100;
        this.force = 10;
    }

    public int getSante() {
        return sante;
    }

    public int getForce() {
        return force;
    }

    public void gagnerSante(int quantite) {
        sante += quantite;
        System.out.println("Vous gagnez " + quantite + " points de santé.");
    }

    public void perdreSante(int quantite) {
        sante -= quantite;
        System.out.println("Vous perdez " + quantite + " points de santé.");
        if (sante <= 0) {
            System.out.println("Vous êtes mort.");
        }
    }

    public void gagnerForce(int quantite) {
        force += quantite;
        System.out.println("Vous gagnez " + quantite + " points de force.");
    }

    public boolean estEnVie() {
        return sante > 0;
    }
}

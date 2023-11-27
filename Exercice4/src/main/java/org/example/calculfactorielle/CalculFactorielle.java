package org.example.calculfactorielle;
import java.util.Scanner;

    public class CalculFactorielle {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Veuillez entrer un nombre de départ : ");

            int nombreDepart = scanner.nextInt();
            scanner.close();
            long factorielle = 1;
            for (int i = 1; i <= nombreDepart; i++) {
                factorielle *= i;
            }
            System.out.println("La factorielle de " + nombreDepart + " est : " + factorielle);
        }
    }



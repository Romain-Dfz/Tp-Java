package org.example.calculcarre;

import java.util.Scanner;

    public class CalculCarre {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Veuillez entrer un nombre : ");
            double nombre = scanner.nextDouble();
            scanner.close();
            double carre = nombre * nombre;
            System.out.println("Le carré de " + nombre + " est : " + carre);
        }
    }



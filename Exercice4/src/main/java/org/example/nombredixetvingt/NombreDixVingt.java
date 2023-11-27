package org.example.nombredixetvingt;

import java.util.Scanner;

public class NombreDixVingt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nombre;

        do {
            System.out.println("Veuillez entrer un nombre entre 10 et 20 : ");
            nombre = scanner.nextInt();

            if (nombre >= 10 && nombre <= 20) {
                break;
            } else {
                if (nombre > 20) {
                    System.out.println("Plus petit !");
                } else {
                    System.out.println("Plus grand !");
                }
            }
        }  while (true);
        System.out.println("La réponse est valide : " + nombre);
        scanner.close();
        }
    }

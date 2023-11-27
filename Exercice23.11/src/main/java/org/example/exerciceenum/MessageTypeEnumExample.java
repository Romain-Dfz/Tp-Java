package org.example.exerciceenum;
import java.util.Scanner;

public class MessageTypeEnumExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MessageType messageType = null;
        do {
            System.out.println("Veuillez entrer le type de message (A, B, C, D) : ");
            String userInput = scanner.nextLine().toUpperCase();
            try {
                messageType = MessageType.valueOf(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Type de message invalide. Veuillez réessayer.");
            }
        } while (messageType == null);

        System.out.println("La priorité du type de message est : " + messageType.getPriority());

        scanner.close();
    }
}



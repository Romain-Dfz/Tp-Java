package org.example.exerciceenum;

public enum MessageType {
    A, B, C, D;
    public Priority getPriority() {
        switch (this) {
            case A:
                return Priority.HIGH;
            case B:
                return Priority.MEDIUM;
            case C,D:
                return Priority.LOW;
            default:
                throw new IllegalArgumentException("Type de message invalide");
        }
    }
}


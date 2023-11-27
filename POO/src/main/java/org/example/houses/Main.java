package org.example.houses;

public class Main {
    public static class MainHouses {
        public static void main(String[] args) {
            Houses.Apartment apartment = new Houses.Apartment();
            Houses.Door door = new Houses.Door("blue");
            Houses.Person person = new Houses.Person("Thomas", apartment, door);
            person.display();
        }
    }
}

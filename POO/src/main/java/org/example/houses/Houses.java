package org.example.houses;

public class Houses {

    public static class House {
        private float surface;

        public House(float surface) {
            this.surface = surface;
        }

        public void display() {
            System.out.println("Je suis une maison, ma surface est de " + surface + " m2");
        }

        public float getSurface() {
            return surface;
        }

        public void setSurface(float surface) {
            this.surface = surface;
        }
    }

    public static class Door {
        private String color;

        public Door(String color) {
            this.color = color;
        }

        public void display() {
            System.out.println("Je suis une porte, ma couleur est " + color);
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static class Apartment extends House {
        public Apartment() {
            super(50);
        }
    }

    public static class Person {
        private String name;
        private House house;
        private Door door;

        public Person(String name, House house, Door door) {
            this.name = name;
            this.house = house;
            this.door = door;
        }

        public void display() {
            System.out.println("Je m'appelle " + name);
            house.display();
            door.display();
        }
    }

}

package org.example.person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(15);
        System.out.println("Hello");

        Student student = new Student();
        student.setAge(15);
        student.goToClasses();
        student.displayAge();

        Teacher teacher = new Teacher("Math");
        teacher.setAge(40);
        teacher.explain();
    }
}

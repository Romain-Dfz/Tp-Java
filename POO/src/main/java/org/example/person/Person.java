package org.example.person;
import static jdk.internal.icu.lang.UCharacter.getAge;
public class Person {
    private int age;

    public void setAge(int n) {
        age = n;
    }
}
class Student extends Person {
    public void goToClasses() {
        System.out.println("I'm going to class.");
    }
    public void displayAge() {
        System.out.println("My age is: " + getAge() + " years old");
    }
    private String getAge() {
        return null;
    }
}
class Teacher extends Person {
    private String subject;

    public Teacher(String sub) {
        subject = sub;
    }
    public void explain() {
        System.out.println("Explanation begins " + subject);
    }
}


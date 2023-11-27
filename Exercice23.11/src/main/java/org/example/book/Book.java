package org.example.book;
import java.math.BigDecimal;
import java.util.Arrays;

enum CoverType {
    PAPERBACK, HARDCOVER
}

class Author {
    int id;
    String firstName;
    String lastName;

    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
    }
}

class Publisher {
    int id;
    String publisherName;

    public Publisher(int id, String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Publisher{id=" + id + ", publisherName='" + publisherName + "'}";
    }
}

public class Book {
    int id;
    String name;
    Author[] authors;
    Publisher publisher;
    int publishingYear;
    int amountOfPages;
    BigDecimal price;
    CoverType coverType;

    public Book(int id, String name, Author[] authors, Publisher publisher, int publishingYear,
                int amountOfPages, BigDecimal price, CoverType coverType) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", name='" + name + "', authors=" + Arrays.toString(authors) +
                ", publisher=" + publisher + ", publishingYear=" + publishingYear +
                ", amountOfPages=" + amountOfPages + ", price=" + price + ", coverType=" + coverType + '}';
    }
}

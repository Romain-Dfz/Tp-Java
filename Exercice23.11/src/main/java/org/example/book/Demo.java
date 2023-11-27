package org.example.book;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Book[] livres = new Book[]{
                new Book(1, "Book_1", new Author[]{new Author(1, "Jon", "Johnson")},
                        new Publisher(1, "Publisher_1"), 1990, 231, BigDecimal.valueOf(24.99),
                        CoverType.PAPERBACK),
                new Book(2, "Book_2", new Author[]{new Author(1, "Jon", "Johnson"),
                        new Author(2, "William", "Wilson")}, new Publisher(2, "Publisher_2 "),
                        2000, 120, BigDecimal.valueOf(14.99), CoverType.PAPERBACK),
                new Book(3, "Book_3", new Author[]{new Author(3, "Walter", "Peterson")},
                        new Publisher(1, "Publisher_1"), 1997, 350, BigDecimal.valueOf(34.99),
                        CoverType.HARDCOVER),
                new Book(4, "Book_4", new Author[]{new Author(4, "Craig", "Gregory")},
                        new Publisher(3, "Publisher_3"), 1992, 185, BigDecimal.valueOf(19.99),
                        CoverType.PAPERBACK)
        };
        BookService bookService = new BookService();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'année de publication minimale : ");
        int year = scanner.nextInt();
        System.out.println("\nLivres publiés après " + year + ":");
        Book[] booksAfterYear = bookService.filterBooksAfterSpecifiedYear(year, livres);
        Arrays.stream(booksAfterYear).forEach(System.out::println);
    }
}


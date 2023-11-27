package org.example.book;
import java.util.Arrays;

public class BookService {
    public Book[] filterBooksByAuthor(Author author, Book[] books) {
        return Arrays.stream(books)
                .filter(book -> Arrays.stream(book.authors).anyMatch(a -> a.id == author.id))
                .toArray(Book[]::new);
    }

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
        return Arrays.stream(books)
                .filter(book -> book.publisher.id == publisher.id)
                .toArray(Book[]::new);
    }

    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
        return Arrays.stream(books)
                .filter(book -> book.publishingYear >= yearFromInclusively)
                .toArray(Book[]::new);
    }
}

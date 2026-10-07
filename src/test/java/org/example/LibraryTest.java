package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void addBook() {
        Library library = new Library();

        Book book = new Book("1984", "George Orwell", 1949);

        library.addBook(book);

        assertEquals(1, library.getBooks().size());
        assertEquals(book, library.getBooks().get(0));
    }

    @Test
    public void removeBook() {
        Library library = new Library();

        Book book = new Book("1984", "George Orwell", 1949);

        library.addBook(book);
        library.removeBook(book);

        assertEquals(0, library.getBooks().size());
    }

    @Test
    public void getBooksByAuthor() {
        Library library = new Library();

        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Animal Farm", "George Orwell", 1945);
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> result =
                library.getBooksByAuthor("George Orwell");

        assertEquals(2, result.size());
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
    }

    @Test
    public void getBooksByYear() {
        Library library = new Library();

        Book book1 = new Book("Book A", "Author A", 2000);
        Book book2 = new Book("Book B", "Author B", 2000);
        Book book3 = new Book("Book C", "Author C", 2010);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> result =
                library.getBooksByYear(2000);

        assertEquals(2, result.size());
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
    }
}
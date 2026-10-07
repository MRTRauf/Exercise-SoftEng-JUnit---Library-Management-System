package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> getBooksByYear(int year) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> getBooks() {
        return books;
    }
}
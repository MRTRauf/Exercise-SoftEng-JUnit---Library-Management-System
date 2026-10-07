package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        int option = -1;

        while (option != 0) {
            System.out.println("\n1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search by author");
            System.out.println("4. Search by year");
            System.out.println("5. Show books");
            System.out.println("0. Exit");
            System.out.print("Option: ");

            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Year: ");

                    try {
                        int year = Integer.parseInt(sc.nextLine());

                        Book book = new Book(title, author, year);
                        library.addBook(book);

                        System.out.println("Book added");
                    } catch (NumberFormatException e) {
                        System.out.println("Year must be a number");
                    }

                    break;

                case 2:
                    System.out.print("Title: ");
                    String titleRemove = sc.nextLine();

                    System.out.print("Author: ");
                    String authorRemove = sc.nextLine();

                    System.out.print("Year: ");

                    try {
                        int yearRemove = Integer.parseInt(sc.nextLine());

                        Book bookRemove =
                                new Book(titleRemove, authorRemove, yearRemove);

                        library.removeBook(bookRemove);

                        System.out.println("Book removed");
                    } catch (NumberFormatException e) {
                        System.out.println("Year must be a number");
                    }

                    break;

                case 3:
                    System.out.print("Author: ");
                    String searchAuthor = sc.nextLine();

                    List<Book> authorBooks =
                            library.getBooksByAuthor(searchAuthor);

                    for (Book b : authorBooks) {
                        System.out.println(b);
                    }

                    break;

                case 4:
                    System.out.print("Year: ");

                    try {
                        int searchYear = Integer.parseInt(sc.nextLine());

                        List<Book> yearBooks =
                                library.getBooksByYear(searchYear);

                        for (Book b : yearBooks) {
                            System.out.println(b);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Year must be a number");
                    }

                    break;

                case 5:
                    for (Book b : library.getBooks()) {
                        System.out.println(b);
                    }

                    break;

                case 0:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Wrong option");
            }
        }

        sc.close();
    }
}
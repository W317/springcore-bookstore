package org.example;

import org.example.config.AppConfig;
import org.example.model.Author;
import org.example.model.Book;
import org.example.service.BookStoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookStoreService bookStoreService = context.getBean(BookStoreService.class);
        startApp(bookStoreService);
    }

    public static void startApp(BookStoreService bookStoreService) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Choosing one option: ");
            System.out.println("1, List All Books");
            System.out.println("2, List All Authors");
            System.out.println("3, Add a new book");
            System.out.println("4, Add a new authors");
            System.out.println("5, Exit");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                choice = 0;
                sc.next();
            }
            switch (choice) {
                case 1 -> {
                    List<Book> bookList = bookStoreService.listAllBooks();
                    bookList.forEach(System.out::println);
                }
                case 2 -> {
                    List<Author> authorList = bookStoreService.listAllAuthors();
                    authorList.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Enter a book name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter a book's author: ");
                    String authorName = sc.nextLine();
                    Author author = new Author(authorName);
                    Book book = new Book(name, author);
                    bookStoreService.addNewBook(book);
                }
                case 4 -> {
                    sc.nextLine();
                    System.out.println("Enter a book's author: ");
                    String nameAuthor = sc.nextLine();
                    Author author1 = new Author(nameAuthor);
                    bookStoreService.addNewAuthor(author1);
                }
                case 5 -> System.out.println("Exit Program");
                default -> {
                    System.out.println("Invalid choice");
                    choice = 0;
                }
            }
        } while (choice!=5);

    }
}
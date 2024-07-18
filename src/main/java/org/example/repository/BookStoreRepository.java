package org.example.repository;

import org.example.model.Author;
import org.example.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class BookStoreRepository {
    private List<Book> books = new ArrayList<>();

    private List<Author> authors = new ArrayList<>();

    public BookStoreRepository() {
        Author author = new Author("John");
        Author author1 = new Author("John1");
        Author author2 = new Author("John2");
        Author author3 = new Author("John3");

        authors.add(author);
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

        books.add(new Book("Harry Potter", author));
        books.add(new Book("Harry Potter", author1));
        books.add(new Book("Harry Potter", author2));
        books.add(new Book("Harry Potter", author3));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addNewBook(Book book) {
        for (Book checkBook : books) {
            if (checkBook.getName().equals(book.getName())) {
                System.out.println("This book already exists");
                return;
            }
        }
        books.add(book);
        authors.add(book.getAuthor());
        System.out.println("Book added successfully: " + book);
    }


    public List<Author> getAllAuthors() {
        Set<String> authorNames = new HashSet<>();
        List<Author> distinctAuthors = new ArrayList<>();
        System.out.println("All Authors Whose Book Are Available");

        for (Book book : books) {
            Author author = book.getAuthor();
            if (authorNames.add(author.getName())) {
                distinctAuthors.add(author);
            }
        }
        return distinctAuthors;
    }


    public void addNewAuthor(Author author) {
        for (Author au : authors) {
            if (au.getName().equals(author.getName())) {
                System.out.println("This author was existed!");
                return;
            }
        }
        authors.add(author);
        System.out.println("Author added successfully: " + author);
    }
}
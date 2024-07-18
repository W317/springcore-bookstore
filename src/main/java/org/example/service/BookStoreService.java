package org.example.service;

import org.example.model.Author;
import org.example.model.Book;

import java.util.List;

public interface BookStoreService {
    List<Book> listAllBooks();
    List<Author> listAllAuthors();

    void addNewBook(Book book);

    void addNewAuthor(Author author);
}

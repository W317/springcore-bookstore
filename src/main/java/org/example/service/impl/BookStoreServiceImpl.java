package org.example.service.impl;

import org.example.model.Author;
import org.example.model.Book;
import org.example.repository.BookStoreRepository;
import org.example.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    private BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        return bookStoreRepository.getAllBooks();
    }

    @Override
    public List<Author> listAllAuthors() {
        return bookStoreRepository.getAllAuthors();
    }

    @Override
    public void addNewBook(Book book) {
        bookStoreRepository.addNewBook(book);
    }

    @Override
    public void addNewAuthor(Author author) {
        bookStoreRepository.addNewAuthor(author);
    }
}

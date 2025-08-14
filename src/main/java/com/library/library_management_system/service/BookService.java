package com.library.library_management_system.service;

import java.util.List;

import com.library.library_management_system.entity.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    Book updateBook(Long id, Book bookDetails);
    void deleteBook(Long id);
    Book addBook(Book book);
    Book getBookById(Long id);

}

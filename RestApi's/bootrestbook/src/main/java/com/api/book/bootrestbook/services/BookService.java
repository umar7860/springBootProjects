package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.models.Book;

@Component
public class BookService {
    // Fake Service

    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(12, "Java Complete Ref", "Umar"));
    // list.add(new Book(13, "Python Complete Ref", "Ali"));
    // list.add(new Book(14, "C Complete Ref", "Faiz"));
    // list.add(new Book(15, "C++ Complete Ref", "Momina"));
    // }

    @Autowired
    private BookRepository bookRepository;

    // getAll books

    public List<Book> getAllBooks() {
        // return list;
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get Book by id
    public Book getBookByID(int id) {
        Book book = null;
        // for (Book book : list) {
        // if(book.getBookId() == id) {
        // return book;
        // }
        // }
        // return null;

        try {
            // Using Stream
            // book = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
            book = this.bookRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Adding new book
    public Book addBook(Book b) {
        // list.add(b);
        Book result = this.bookRepository.save(b);
        return result;
        // return b;
    }

    // delete book

    public void deleteBook(int id) {
        // int i = 0;
        // for (Book book : list) {

        // if(book.getBookId() == id) {
        // list.remove(i);
        // }
        // i++;
        // }

        // list = list.stream().filter(book -> {
        // if(book.getBookId() != id) {
        // return true;
        // } else {
        // return false;
        // }

        // }).collect(Collectors.toList());
        bookRepository.deleteById(id);
        // list = list.stream().filter(book -> book.getBookId() !=
        // id).collect(Collectors.toList());
    }

    public void updateBook(Book book, int bookId) {

        // list = list.stream().map(b -> {
        // if (b.getBookId() == bookId) {
        // b.setAuthor(book.getAuthor());
        // b.setTitle(book.getTitle());
        // }
        // return b;

        // }).collect(Collectors.toList());
        book.setBookId(bookId);
        this.bookRepository.save(book);
    }
}

package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.models.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;
    // @RequestMapping(value="/books", method= RequestMethod.GET)
    @GetMapping("/books")
    public List<Book> getBooks() {
        // return "This is testing Book";
        // Book myBook = new Book();
        // myBook.setBookId(12);
        // myBook.setAuthor("Umar");
        // myBook.setTitle("Java compplete Reference");
        return this.bookService.getAllBooks();
    }

    //get Single book
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBookByID(id);
    }

    //Adding new book
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    //Deleteing the book

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int id) {
        this.bookService.deleteBook(id);

    }
}

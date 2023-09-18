package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.models.Book;

@Component
public class BookService {
    //Fake Service


    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(12,"Java Complete Ref","Umar"));
        list.add(new Book(13,"Python Complete Ref","Ali"));
        list.add(new Book(14,"C Complete Ref","Faiz"));
        list.add(new Book(15,"C++ Complete Ref","Momina"));
    }


    //getAll books

    public List<Book> getAllBooks() {
        return list;
    }

    //get Book by id
    public Book getBookByID(int id) {
        Book book ;
        // for (Book book : list) {
        //     if(book.getBookId() == id) {
        //         return book;
        //     }
        // }
        // return null;

        //Using Stream
       book =  list.stream().filter(e-> e.getBookId() == id).findFirst().get();
       return book;
    }

    //Adding new book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }
}

package com.springboot.SecureWebApp.controller;

import com.springboot.SecureWebApp.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    private static Map<Integer, Book> bookstore = new HashMap<>();

    static {
        Book book1 = new Book(123, "Alice in Wonderland", "Lewis Carrol");
        bookstore.put(book1.getId(), book1);

        Book book2 = new Book(456, "Anna Karenina", "Leo Tolstoy");
        bookstore.put(book2.getId(), book2);
    }

    @RequestMapping(value = "/")
    public String welcome() {
        return "<h2>Welcome To The Bookstore!</h2>";
    }
    /*
     * Description: 
     * Output: JSON
     */
    @RequestMapping(value = "/book")
    public ResponseEntity<Object> getBook(@RequestParam("bookId") Integer bookId) {

        System.out.println("Retrieving Book...");

        return new ResponseEntity<>(bookstore.get(bookId), HttpStatus.OK);
    }
}

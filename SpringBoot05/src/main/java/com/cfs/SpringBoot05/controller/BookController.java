package com.cfs.SpringBoot05.controller;

// Book entity import – JSON ↔ Java conversion ke liye
import com.cfs.SpringBoot05.entity.Book;

// HTTP status codes ke liye
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// REST annotations
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @RestController = @Controller + @ResponseBody
// Matlab: har method ka return JSON ban kar client ko jayega
@RestController

// Base URL for all APIs in this controller
@RequestMapping("/books")
public class BookController {

    // In-memory database (temporary storage)
    // Key = Book ID, Value = Book object
    // App restart → data delete ho jayega
    private Map<Long, Book> books = new HashMap<>();


    // ===================== GET ALL BOOKS =====================
    // URL: GET /books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        // books.values() → Collection<Book>
        // new ArrayList → JSON array banane ke liye
        // ResponseEntity.ok → HTTP 200 OK
        return ResponseEntity.ok(new ArrayList<>(books.values()));
    }


    // ===================== CREATE BOOK =====================
    // URL: POST /books
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {

        // @RequestBody:
        // JSON body → Book Java object (Jackson karta hai)
        books.put(book.getId(), book);

        // 201 CREATED kyunki new resource create hui hai
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }


    // ===================== GET BOOK BY ID =====================
    // URL: GET /books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        // @PathVariable:
        // URL se id uthata hai (e.g. /books/1 → id = 1)
        Book book = books.get(id);

        // Agar book nahi mili
        if (book == null) {
            // 404 NOT FOUND → resource exist nahi karti
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Book mil gayi → 200 OK
        return ResponseEntity.ok(book);
    }


    // ===================== FULL UPDATE (PUT) =====================
    // URL: PUT /books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(
            @PathVariable Long id,
            @RequestBody Book book) {

        // Check kar rahe hain book exist karti hai ya nahi
        Book existingBook = books.get(id);

        if (existingBook == null) {
            // Update possible nahi → 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // PUT ka rule:
        // Poora object replace hota hai
        books.put(id, book);

        // 204 NO CONTENT:
        // Update successful but response body nahi
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    // ===================== PARTIAL UPDATE (PATCH) =====================
    // URL: PATCH /books/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<Book> updatePrice(
            @PathVariable Long id,
            @RequestBody Double price) {

        // Existing book fetch
        Book existingBook = books.get(id);

        if (existingBook == null) {
            // Book nahi mili → 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Sirf price update ho rahi hai
        existingBook.setPrice(price);

        // Updated object wapas map me daal diya
        books.put(id, existingBook);

        // 200 OK + updated book return
        return ResponseEntity.ok(existingBook);
    }


    // ===================== DELETE BOOK =====================
    // URL: DELETE /books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {

        // remove() → delete + return deleted object
        Book deletedBook = books.remove(id);

        if (deletedBook == null) {
            // Delete karne ke liye kuch tha hi nahi
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 204 NO CONTENT:
        // Delete successful, response body nahi
        return ResponseEntity.noContent().build();
    }
}

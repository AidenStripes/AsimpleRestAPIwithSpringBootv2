package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5173/")
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping
public class BookController {

    @Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Iterable findAll() { return bookRepository.findAll(); }

    @PostMapping(value = "/books", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping(value = "/books/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookRepository.save(book);
    }
}

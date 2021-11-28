package com.kyang47.as2.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "{bookId}")
    public Book getBookById(@PathVariable("bookId") Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(@PathVariable("bookId") Long id, @RequestBody Book book) {
        bookService.updateBook(id, book.getTitle(), book.getSummary());
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long id) {
        bookService.deleteBook(id);
    }
}

package com.kyang47.as2.library;

import com.kyang47.as2.book.Book;
import com.kyang47.as2.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/library")
public class LibraryController {
    private final LibraryService libraryService;
    private final BookService bookService;

    @Autowired
    public LibraryController(LibraryService libraryService, BookService bookService) {
        this.libraryService = libraryService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<Library> getLibraries() {
        return libraryService.getLibraries();
    }

    @GetMapping(path = "{libraryId}")
    public Library getLibraryById(@PathVariable("libraryId") Long id) {
        return libraryService.getLibraryById(id);
    }

    @PostMapping
    public void addLibrary(@RequestBody Library library) {
        libraryService.addNewLibrary(library);
    }

    @PutMapping(path = "{libraryId}")
    public void updateLibrary(@PathVariable("libraryId") Long id, @RequestBody Library library) {
        libraryService.updateLibrary(id, library.getAddress());
    }

    @DeleteMapping(path = "{libraryId}")
    public void deleteLibrary(@PathVariable("libraryId") Long id) {
        libraryService.deleteLibrary(id);
    }

    @PostMapping(path = "{libraryId}/book")
    public void addLibrary(@RequestBody Book book, @PathVariable("libraryId") Long id) {
        bookService.addNewBook(book, id);
    }
}
